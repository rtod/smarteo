package com.toader.smarteo.controller;

import com.toader.smarteo.bean.Entry;
import com.toader.smarteo.bean.SmarteoResponse;
import com.toader.smarteo.dao.EntryEntity;
import com.toader.smarteo.service.SmarteoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
public class SmarteoController {

    private SmarteoService smarteoService;

    @PostMapping("/addEntry")
    public SmarteoResponse addEntry(@RequestBody Entry entry) {
        return SmarteoResponse.builder().entries(Collections.singletonList(smarteoService.save(entry))).returnMessage("You have successfully added an entry!").build();
    }

    @PostMapping("/addEntries")
    public SmarteoResponse addEntries(@RequestBody List<Entry> entries) {
        return SmarteoResponse.builder().entries(smarteoService.saveAll(entries)).returnMessage("You have successfully added an entry!").build();
    }

    @GetMapping("/getEntry")
    public SmarteoResponse getEntry(@RequestParam String email) {
        EntryEntity entryEntity = smarteoService.findByEmail(email);
        return SmarteoResponse.builder().entries(Collections.singletonList(entryEntity)).returnMessage("Entry retrieved successfully!").build();
    }

    @GetMapping("/getEntries")
    public SmarteoResponse getEntries() {
        return SmarteoResponse.builder().entries(smarteoService.findAll()).returnMessage("Entries retrieved successfully!").build();
    }

    @DeleteMapping("/deleteEntry")
    public SmarteoResponse deleteEntry(@RequestParam String email) {
        return SmarteoResponse.builder().entries(smarteoService.deleteByEmail(email)).returnMessage("Entry deleted successfully!").build();
    }

    @PutMapping("/updateEntry")
    public SmarteoResponse updateEntry(@RequestParam String email, @RequestBody Entry entry) {
        return SmarteoResponse.builder().entries(smarteoService.updateByEmail(email, entry)).returnMessage("Entry updated successfully!").build();
    }
}
