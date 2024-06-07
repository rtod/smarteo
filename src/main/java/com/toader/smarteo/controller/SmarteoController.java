package com.toader.smarteo.controller;

import com.toader.smarteo.dto.SmarteoResponse;
import com.toader.smarteo.entity.User;
import com.toader.smarteo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(path = "/v1/smarteo/api")
@AllArgsConstructor
public class SmarteoController {

    private UserService userService;

    @PostMapping("/addEntry")
    public SmarteoResponse addEntry(@RequestBody User user) {
        return SmarteoResponse.builder().users(Collections.singletonList(userService.saveUser(user))).returnMessage("You have successfully added an entry!").build();
    }

    @GetMapping("/getEntries")
    public SmarteoResponse getEntries() {
        return SmarteoResponse.builder().users(userService.fetchUserList()).returnMessage("Entries retrieved successfully!").build();
    }

    @DeleteMapping("/deleteEntry")
    public SmarteoResponse deleteEntry(@RequestParam Long userId) {
        return SmarteoResponse.builder().users(Collections.singletonList(userService.deleteUserById(userId))).returnMessage("User deleted successfully!").build();
    }

    @PutMapping("/updateEntry")
    public SmarteoResponse updateEntry(@RequestParam Long userId, @RequestBody User user) {
        return SmarteoResponse.builder().users(Collections.singletonList(userService.updateUser(user, userId))).returnMessage("User updated successfully!").build();
    }
}
