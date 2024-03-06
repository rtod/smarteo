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
        SmarteoResponse smarteoResponse = new SmarteoResponse();
        smarteoResponse.setReturnMessage("You have succesfully added an entry!");
        return smarteoResponse;
    }

    @GetMapping("/helloWorld")
    public String helloWorld(){
        return "Hello World";
    }
}
