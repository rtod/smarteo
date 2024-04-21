package com.toader.smarteo.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@Table(name = "entries")
@AllArgsConstructor
@NoArgsConstructor
public class EntryEntity {
    @Id
    @Column(length = 200)
    private String email;
    private String name;
}
