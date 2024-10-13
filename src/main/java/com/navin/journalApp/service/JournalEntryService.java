package com.navin.journalApp.service;

import com.navin.journalApp.entity.JournalEntry;
import com.navin.journalApp.entity.User;
import com.navin.journalApp.repository.JournalEntryRepository;
import org.bson.types.ObjectId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;


    @Transactional
    public void saveEntry(JournalEntry journalEntry, String username) {
        User user = userService.findByUsername(username);
        JournalEntry save = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(save);
        userService.saveUser(user);
    }

    public void saveEntry(JournalEntry journalEntry) {

        journalEntryRepository.save(journalEntry);

    }

    public List<JournalEntry> getAllEntry() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getEntryById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteEntryById(ObjectId id, String username) {
        boolean removedIf = false;
        try {

            User user = userService.findByUsername(username);
            removedIf = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removedIf) {
                userService.saveUser(user);
                journalEntryRepository.deleteById(id);
            }
        }catch (Exception e){

            System.out.println(e.getMessage());
        }
        return removedIf;
    }
}
