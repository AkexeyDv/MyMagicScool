package com.pro.sky.ScoolHogwartsMagic.Controllers;

import com.pro.sky.ScoolHogwartsMagic.Services.IterateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("streame")
public class StreamController {
    private final IterateService iterateService;

    public StreamController(IterateService iterateService) {
        this.iterateService = iterateService;
    }

}
