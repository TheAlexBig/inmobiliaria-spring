package com.root.inmobiliaria.domain.auth

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
data class Role(
        @Id
        var id : String? = "1",
        var name : String = "client",

        @ManyToMany(mappedBy = "roles")
        var users : Set<User>
)