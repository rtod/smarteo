package com.toader.smarteo.controller;

import com.toader.smarteo.dto.Entry;
import com.toader.smarteo.dto.SmarteoResponse;
import com.toader.smarteo.dao.EntryEntity;
import com.toader.smarteo.service.SmarteoEntryRepositoryImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/smarteo/api")
@AllArgsConstructor
public class SmarteoController {

    private SmarteoEntryRepositoryImpl smarteoEntryRepositoryImpl;

    @PostMapping("/addEntry")
    public SmarteoResponse addEntry(@RequestBody Entry entry) {
        return SmarteoResponse.builder().entries(Collections.singletonList(smarteoEntryRepositoryImpl.save(entry))).returnMessage("You have successfully added an entry!").build();
    }

    @PostMapping("/addEntries")
    public SmarteoResponse addEntries(@RequestBody List<Entry> entries) {
        //TODO: check if entry exists
        return SmarteoResponse.builder().entries(smarteoEntryRepositoryImpl.saveAll(entries)).returnMessage("You have successfully added an entry!").build();
    }

    @GetMapping("/getEntry")
    public SmarteoResponse getEntry(@RequestParam String email) {
        EntryEntity entryEntity = smarteoEntryRepositoryImpl.findByEmail(email);
        return SmarteoResponse.builder().entries(Collections.singletonList(entryEntity)).returnMessage("Entry retrieved successfully!").build();
    }

    @GetMapping("/getEntries")
    public SmarteoResponse getEntries() {
        return SmarteoResponse.builder().entries(smarteoEntryRepositoryImpl.findAll()).returnMessage("Entries retrieved successfully!").build();
    }

    @DeleteMapping("/deleteEntry")
    public SmarteoResponse deleteEntry(@RequestParam String email) {
        return SmarteoResponse.builder().entries(smarteoEntryRepositoryImpl.deleteByEmail(email)).returnMessage("Entry deleted successfully!").build();
    }

    @PutMapping("/updateEntry")
    public SmarteoResponse updateEntry(@RequestParam String email, @RequestBody Entry entry) {
        return SmarteoResponse.builder().entries(smarteoEntryRepositoryImpl.updateByEmail(email, entry)).returnMessage("Entry updated successfully!").build();
    }
}
