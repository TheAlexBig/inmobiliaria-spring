package com.root.inmobiliaria.domain

import com.github.fabiomaffioletti.firebase.document.FirebaseDocument

@FirebaseDocument("/position")
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