package com.darya.crossfit.controller;

import com.darya.crossfit.service.CrossfitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CrossfitController {

    private final CrossfitService crossfitService;

    public CrossfitController(CrossfitService crossfitService) {
        this.crossfitService = crossfitService;
    }

    @GetMapping
    public String client(@RequestParam Integer clientId) throws IOException {
       return crossfitService.client(clientId);
    }
}
