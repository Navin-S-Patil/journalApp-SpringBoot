package com.navin.journalApp.service;

import com.navin.journalApp.api.response.WeatherResponse;
import com.navin.journalApp.cache.AppCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherApiService {

    @Value("${weather.api.key}")
    private String API_KEY;

    @Autowired
    private AppCache appCache;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeatherForcast(String city) {
        WeatherResponse weatherResponse = redisService.get("weather_of_" + city, WeatherResponse.class);
        if (weatherResponse != null) return weatherResponse;
        else {
            String final_API = appCache.appCache.get("WEATHER_API").replace("<city>", city).replace("<apiKey>", API_KEY);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(final_API, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body != null) redisService.set("weather_of_" + city, body,300l);
            return body;
        }
    }
}
