package com.root.inmobiliaria.controller

import com.root.inmobiliaria.config.FirebaseSetUp
import com.root.inmobiliaria.service.QuoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MainController{

    @Autowired
    lateinit var quoteService : QuoteService

    @GetMapping("/")
    fun starUp():String{
        quoteService.searchQuote().forEach {
            println(it.toString())
        }
        return "index"
    }

    @PostMapping("/search")
    fun search(): String{
        return "search"
    }
}