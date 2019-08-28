package com.root.inmobiliaria.domain.auth

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class User (
    @Id
    var id: String = "1",

    var email: String = "",

    var username: String = "",

    var password: String = "",

    var passwordConfirm: String ="",

    @ManyToMany
    var roles: Set<Role>? = null
){}