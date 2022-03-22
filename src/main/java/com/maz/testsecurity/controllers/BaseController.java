package com.maz.testsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@Controller
public class BaseController {

    @GetMapping
    public ResponseEntity<?> getOkResponse() {
        return ResponseEntity.ok().build();
    }

}
