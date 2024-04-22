package com.toader.smarteo.dto;

import com.toader.smarteo.dao.EntryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SmarteoResponse {
    private List<EntryEntity> entries;
    private String returnMessage;
}
