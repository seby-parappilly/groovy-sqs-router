package com.spp.sqs.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AppController {

    @GetMapping("/home")
    public String greeting(){
        "Hello, Welcome to Amazon SQS Apache Camel Router App !!"
    }
}
