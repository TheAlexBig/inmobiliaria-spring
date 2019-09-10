package com.root.inmobiliaria.controller

import com.root.inmobiliaria.domain.Position
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class MainController{


    @GetMapping("/")
    fun starUp(model: Model):String{
        //model.addAttribute("Quote",  quoteService.searchQuote())
        return "visual/index"
    }

    @GetMapping("/contact-us")
    fun contact(model: Model): String{
        return "visual/contact-us"
    }

    @RequestMapping("/search", method = [RequestMethod.POST, RequestMethod.GET])
    fun search(model: Model): String{
        val location = Position(13.651112, -89.280812, "ubicación")
        val points : MutableList<Position> = ArrayList<Position>()
        points.add(Position(13.671660,-89.278015,"hospital"))
        points.add(Position(13.456558, -89.043058, "aeropuerto"))
        points.add(Position(13.651044, -89.280783, "gimnasio"))
        points.add(Position(13.651612, -89.280708, "escuela"))
        points.add(Position(13.671881, -89.283397, "estacion de bus"))
        points.add(Position(13.647980, -89.265698, "libreria"))


        model.addAttribute("location", location)
        model.addAttribute("points", points.toList())
        return "visual/search"
    }

    @RequestMapping("/description", method = [RequestMethod.GET,RequestMethod.POST])
    fun description(model: Model): String{
        val location = Position(13.651112, -89.280812, "ubicación")
        val points : MutableList<Position> = ArrayList<Position>()
        points.add(Position(13.671660,-89.278015,"hospital"))
        points.add(Position(13.456558, -89.043058, "aeropuerto"))
        points.add(Position(13.651044, -89.280783, "gimnasio"))
        points.add(Position(13.651612, -89.280708, "escuela"))
        points.add(Position(13.671881, -89.283397, "estacion de bus"))
        points.add(Position(13.647980, -89.265698, "libreria"))


        model.addAttribute("location", location)
        model.addAttribute("points", points.toList())
        return "visual/description"
    }



}