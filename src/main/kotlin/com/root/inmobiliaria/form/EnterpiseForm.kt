package com.root.inmobiliaria.form

import javax.validation.constraints.NotEmpty

data class EnterpiseForm(
        @field:NotEmpty(message = "Ingrese una foto de perfil")
        var profilePic : String = "",

        @field:NotEmpty(message = "Ingrese una dirección de correo")
        var address : String = "",

        @field:NotEmpty(message = "Ingrese un docmuento de indentificación")
        var document : String = "",

        @field:NotEmpty(message = "Ingrese sus nombres")
        var names : String  = ""
){

}