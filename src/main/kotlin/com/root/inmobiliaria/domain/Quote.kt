package com.root.inmobiliaria.domain

import javax.persistence.Entity


@Entity
data class Quote(

    var quote : String = "",
    var author : String = ""
    )
{

}

