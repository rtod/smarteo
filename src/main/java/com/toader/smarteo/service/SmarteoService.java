package com.toader.smarteo.service;

import com.toader.smarteo.bean.Entry;
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

    public EntryEntity findByName(String name) {
        return entryRepository.findByName(name);
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

    public List<EntryEntity> deleteById(long id) {
        EntryEntity entryEntity = entryRepository.findById(id);
        entryRepository.deleteById(id);
        return Collections.singletonList(entryEntity);
    }

    public List<EntryEntity> updateById(long id, Entry entry) {
        EntryEntity entryEntity = entryRepository.findById(id);
        entryEntity.setName(entry.getName());
        entryEntity.setEmail(entry.getEmail());
        entryRepository.save(entryEntity);
        return Collections.singletonList(entryEntity);
    }
}
