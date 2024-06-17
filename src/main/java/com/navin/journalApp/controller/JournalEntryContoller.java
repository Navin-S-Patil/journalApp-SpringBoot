//package com.navin.journalApp.controller;
//
//import com.navin.journalApp.entity.JournalEntry;
//import org.bson.types.ObjectId;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryContoller {
//
//    private Map<ObjectId, JournalEntry> journalEntryMap = new HashMap<>();
//
//    @GetMapping
//    public List<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntryMap.values());
//    }
//
//    @GetMapping("/id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId){
//        return journalEntryMap.get(myId);
//    }
//
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry entry){
//        journalEntryMap.put(entry.getId(), entry);
//        return true;
//    }
//    @DeleteMapping("/id/{myId}")
//    public JournalEntry deleteEntry(@PathVariable Long myId){
//        return journalEntryMap.remove(myId);
//    }
//
//    @PutMapping("/id/{myId}")
//    public JournalEntry updateEntry(@PathVariable ObjectId myId, @RequestBody JournalEntry entry){
//        return journalEntryMap.put(myId,entry);
//    }
//
//}
