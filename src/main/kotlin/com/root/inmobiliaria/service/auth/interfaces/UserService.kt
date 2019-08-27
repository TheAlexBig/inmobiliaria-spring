package com.root.inmobiliaria.service.auth.interfaces

import com.root.inmobiliaria.domain.auth.User

interface UserService {
    fun save(user: User)

    fun findByUsername(username: String): User
}