package com.root.inmobiliaria.form

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class UserForm (
        var id: Int = 0,

        @field:NotEmpty(message = "Ingrese un correo electronico")
        var email: String = "",

        @field:NotEmpty(message = "Digite su nombre de usuario")
        @field:Size(min=8, max = 32, message =  "Por favor use de 8 a 32 caracteres")
        var username: String = "",

        @field:NotEmpty(message = "Ingrese el campo de su clave secreta")
        @field:Size(min=8, max = 32, message =  "Por favor use de 8 a 32 caracteres")
        var password: String = "",

        @field:NotEmpty(message = "Este campo no puede estar vacio")
        @field:Size(min=8, max = 32, message =  "Por favor use de 8 a 32 caracteres")
        var passwordConfirm: String =""

){

}