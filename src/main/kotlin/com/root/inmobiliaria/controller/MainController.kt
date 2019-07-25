package com.root.inmobiliaria.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController{

    @GetMapping("/")
    fun starUp():String{
        return "index"
    }
}