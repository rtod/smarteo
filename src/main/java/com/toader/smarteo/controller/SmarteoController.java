package com.toader.smarteo.controller;

import com.toader.smarteo.bean.Entry;
import com.toader.smarteo.bean.SmarteoResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class SmarteoController {

    @PostMapping("/addEntry")
    public SmarteoResponse addEntry(@RequestBody Entry entry, HttpServletRequest request) {
        return SmarteoResponse.builder().entry(entry).returnMessage("You have successfully added an entry!").build();
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }
}
