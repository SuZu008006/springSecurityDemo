package com.example.security

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
@CrossOrigin(origins = ["http://localhost:3000", "https://menuplanner-web.herokuapp.com"])
class Controller {
    @GetMapping
    fun getMessage(): List<String> {
        return listOf("hello")
    }
}