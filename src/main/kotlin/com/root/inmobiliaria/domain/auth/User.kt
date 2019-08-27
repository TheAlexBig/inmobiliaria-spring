package com.root.inmobiliaria.domain.auth

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class User (
    @Id
    var id: String? = "1",

    var email: String = "Default_email",

    var username: String? = "Default_username",

    var password: String? = "Default_password",

    var passwordConfirm: String? ="Default_confirm",

    @ManyToMany
    var roles: Set<Role>? = null
){}