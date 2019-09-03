package com.root.inmobiliaria.service.auth.interfaces

import com.root.inmobiliaria.domain.auth.User
import java.util.*

interface UserService {
    fun save(user: User)

    fun findByUsername(username: String): Optional<User>
    fun findByUsernameOrEmail (username: String, email : String) : Optional<User>
}