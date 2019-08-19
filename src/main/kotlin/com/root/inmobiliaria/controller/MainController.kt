package com.root.inmobiliaria.controller

import com.root.inmobiliaria.domain.Position
import com.root.inmobiliaria.service.QuoteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
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
        return "client/index"
    }

    @GetMapping("/contact-us")
    fun contact(model: Model): String{
        return "client/contact-us"
    }

    @RequestMapping("/search", method = [RequestMethod.GET,RequestMethod.POST])
    fun search(model: Model): String{
        val location = Position(13.651112, -89.280812)
        model.addAttribute("location", location)
        return "client/search"
    }

    @RequestMapping("/description", method = [RequestMethod.GET,RequestMethod.POST])
    fun description(model: Model): String{
        val location = Position(13.651112, -89.280812, "objetivo")
        val points : MutableList<Position> = ArrayList<Position>()
        points.add(Position(13.671660,-89.278015,"hospital"))
        points.add(Position(13.456558, -89.043058, "aeropuerto"))
        points.add(Position(13.651044, -89.280783, "gimnasio"))
        points.add(Position(13.651612, -89.280708, "escuela"))
        points.add(Position(13.671881, -89.283397, "estacion-de-bus"))
        points.add(Position(13.647980, -89.265698, "libreria"))


        model.addAttribute("location", location)
        model.addAttribute("points", points.toList())
        return "client/description"
    }
}