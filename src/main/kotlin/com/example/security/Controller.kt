package com.example.security

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@CrossOrigin(origins = ["http://localhost:3000", "https://menuplanner-web.herokuapp.com"])
class SampleController {
    @RequestMapping("/")
    fun index(): String {
        return "index"
    }
}

@RestController
@RequestMapping("/api/greeting")
@CrossOrigin(origins = ["http://localhost:3000", "https://menuplanner-web.herokuapp.com"])
class Controller {
    @GetMapping
    fun getMessage(): List<String> {
        return listOf("hello")
    }
}