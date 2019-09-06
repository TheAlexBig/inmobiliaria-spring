package com.root.inmobiliaria.form

import javax.validation.constraints.NotEmpty


data class ClientForm(

        @field:NotEmpty(message = "Ingrese una foto de perfil")
        var profilePic : String = "",

        @field:NotEmpty(message = "Ingrese su país de origen")
        var country : String = "",

        @field:NotEmpty(message = "Ingrese el nombre de la ciudad")
        var city : String = "",

        @field:NotEmpty(message ="Ingrese el nombre del documento utilizado")
        var documentName : String = "",

        @field:NotEmpty(message = "Ingrese el codigo de dicho documento")
        var document : String = "",

        @field:NotEmpty(message = "Ingrese sus nombres")
        var names : String  = "",

        @field:NotEmpty(message = "Ingrese sus apellidos")
        var lastNames : String = "",

        @field:NotEmpty(message = "Ingrese un número de contacto")
        var contactPhone : String = "",

        var sex  : Boolean = false
        )
{

}