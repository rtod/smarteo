package com.toader.smarteo.bean;

import com.toader.smarteo.dao.EntryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SmarteoResponse {
    private EntryEntity entry;
    private String returnMessage;
}
