package com.toader.smarteo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SmarteoResponse {
    private Entry entry;
    private String returnMessage;
}
