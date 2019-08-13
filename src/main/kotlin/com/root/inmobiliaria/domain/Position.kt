package com.root.inmobiliaria.domain

data class Position(
        var lat : Double = 0.0,
        var lng : Double = 0.0,
        var name : String = ""
)
{
    override fun toString(): String {
        return "lat:$lat, lng$lng";
    }
}