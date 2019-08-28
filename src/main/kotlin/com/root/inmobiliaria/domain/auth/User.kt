package com.root.inmobiliaria.domain.auth

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
data class User (
    @Id
    var id: String = "1",

    @field:NotEmpty(message = "Ingrese el campo de correo")
    var email: String = "",

    @field:NotEmpty(message = "Ingrese su nombre de usuario")
    @field:Size(min=8, max = 32, message =  "Por favor use entre 8 a 32 caracteres")
    var username: String = "",

    @field:NotEmpty(message = "Ingrese el campo de su clave secreta")
    @field:Size(min=8, max = 32, message =  "Por favor use entre 8 a 32 caracteres")
    var password: String = "",

    @field:NotEmpty(message = "Ingrese el campo. No puede estar vacio")
    var passwordConfirm: String ="",

    @ManyToMany
    var roles: Set<Role>? = null
){}