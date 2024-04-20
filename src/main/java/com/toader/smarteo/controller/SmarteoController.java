package com.toader.smarteo.controller;

import com.toader.smarteo.bean.Entry;
import com.toader.smarteo.bean.SmarteoResponse;
import com.toader.smarteo.dao.EntryEntity;
import com.toader.smarteo.service.EntryRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class SmarteoController {

    private EntryRepository entryRepository;

    @PostMapping("/addEntry")
    public SmarteoResponse addEntry(@RequestBody Entry entry, HttpServletRequest request) {
        EntryEntity entryEntity = EntryEntity.builder().name(entry.getName()).email(entry.getEmail()).build();
        entryRepository.save(entryEntity);
        return SmarteoResponse.builder().entry(entryEntity).returnMessage("You have successfully added an entry!").build();
    }

    @GetMapping("/getEntry")
    public SmarteoResponse getEntry(@RequestParam String name){
        EntryEntity entryEntity = entryRepository.findByName(name);
        return SmarteoResponse.builder().entry(entryEntity).returnMessage("Entry retrieved succesfully!").build();
    }

    @GetMapping("/getEntries")
    public List<EntryEntity> getEntries(){

        return entryRepository.findAll();
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }
}
