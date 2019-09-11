package com.root.inmobiliaria.form

import javax.validation.constraints.NotEmpty

data class ProfileForm(
        @field:NotEmpty(message="Ingrese la dirección")
        var address : String = "",

        @field:NotEmpty(message="Asigne un tipo de documento")
        var documentName : String = "",

        @field:NotEmpty(message="Asegurese de ingresar el documento")
        var document : String = "",

        @field:NotEmpty(message="Asegurese de ingresar su telefono")
        var phone : String = "",

        @field:NotEmpty(message="Proporcione sus nombres")
        var names : String = "",

        @field:NotEmpty(message="Ingrese sus apellidos")
        var lastName : String = "",

        @field:NotEmpty(message="Error en campo")
        var sex : Boolean = false

){}