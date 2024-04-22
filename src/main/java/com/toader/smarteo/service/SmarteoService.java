package com.toader.smarteo.service;

import com.toader.smarteo.dto.Entry;
import com.toader.smarteo.dao.EntryEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class SmarteoService {

    private EntryRepository entryRepository;

    public EntryEntity save(Entry entry) {
        EntryEntity entryEntity = EntryEntity.builder().name(entry.getName()).email(entry.getEmail()).build();
        entryRepository.save(entryEntity);
        return entryEntity;
    }

    public EntryEntity findByEmail(String email) {
        return entryRepository.findByEmail(email);
    }

    public List<EntryEntity> findAll() {
        return entryRepository.findAll();
    }

    public List<EntryEntity> saveAll(List<Entry> entries) {
        List<EntryEntity> entryEntities = new ArrayList<>();
        for (Entry entry : entries) {
            EntryEntity entryEntity = EntryEntity.builder().name(entry.getName()).email(entry.getEmail()).build();
            entryRepository.save(entryEntity);
            entryEntities.add(entryEntity);
        }
        return entryEntities;
    }

    public List<EntryEntity> deleteByEmail(String email) {
        EntryEntity entryEntity = entryRepository.findByEmail(email);
        entryRepository.deleteByEmail(email);
        return Collections.singletonList(entryEntity);
    }

    public List<EntryEntity> updateByEmail(String email, Entry entry) {
        EntryEntity entryEntity = entryRepository.findByEmail(email);
        entryEntity.setName(entry.getName());
        entryRepository.save(entryEntity);
        return Collections.singletonList(entryEntity);
    }
}
