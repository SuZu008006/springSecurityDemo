package com.example.security

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class SampleController {
    @RequestMapping("/")
    fun index(): String {
        return "index"
    }
}