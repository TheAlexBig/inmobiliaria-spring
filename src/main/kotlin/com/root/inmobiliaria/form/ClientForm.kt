package com.root.inmobiliaria.form

import javax.validation.constraints.NotEmpty

data class ClientForm(
        @field:NotEmpty(message="Ingrese la dirección")
        var address : String = ""
){}