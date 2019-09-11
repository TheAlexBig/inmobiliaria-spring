package com.root.inmobiliaria.repositories

import com.root.inmobiliaria.domain.auth.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UserRepository : CrudRepository<User, UUID>{
    fun findByUsername(username: String): Optional<User>
    fun findByUsernameOrEmail(username: String, email: String): Optional<User>
    fun findByEmail(email : String) : Optional<User>
}