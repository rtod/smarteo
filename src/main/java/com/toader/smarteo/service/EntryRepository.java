package com.toader.smarteo.service;

import com.toader.smarteo.dao.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<EntryEntity, Long> {
    EntryEntity findByEmail(String entryEmail);

    EntryEntity save(EntryEntity entryEntity);

    List<EntryEntity> findAll();

    void deleteByEmail(String entryEmail);
}
