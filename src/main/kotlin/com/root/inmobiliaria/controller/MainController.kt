package com.root.inmobiliaria.controller

import com.root.inmobiliaria.config.FirebaseSetUp
import com.root.inmobiliaria.service.QuoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class MainController{

    @Autowired
    lateinit var quoteService : QuoteService

    @GetMapping("/")
    fun starUp(model: Model):String{
        //model.addAttribute("Quote",  quoteService.searchQuote())
        quoteService.searchQuote()
        return "index"
    }

    @RequestMapping("/search", method = [RequestMethod.GET,RequestMethod.POST])
    fun search(model: Model): String{
        return "search"
    }

    @RequestMapping("/description", method = [RequestMethod.GET,RequestMethod.POST])
    fun description(model: Model): String{
        return "description"
    }
}