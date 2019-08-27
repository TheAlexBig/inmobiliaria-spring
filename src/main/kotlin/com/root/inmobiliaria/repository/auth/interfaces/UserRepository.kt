package com.root.inmobiliaria.repository.auth.interfaces

import com.root.inmobiliaria.domain.auth.User

interface UserRepository{
    fun save(user: User)

    fun findByUsername(username: String): User
}