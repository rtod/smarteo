package com.toader.smarteo.dto;

import com.toader.smarteo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class SmarteoResponse {
    private List<User> users;
    private String returnMessage;
}
