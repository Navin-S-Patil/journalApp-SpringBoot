package com.navin.journalApp.repository;

import com.navin.journalApp.entity.ConfigJournalApp;
import com.navin.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository<ConfigJournalApp, ObjectId> {

}
