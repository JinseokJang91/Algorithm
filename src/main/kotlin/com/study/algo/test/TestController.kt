package com.study.algo.test

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class TestController {
    @GetMapping("/ping")
    fun ping(): String {
        return "ping test";
    }
}