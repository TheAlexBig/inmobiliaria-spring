package com.root.inmobiliaria.repositories

import com.root.inmobiliaria.domain.auth.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Int>{
    fun findByUsername(username: String): User
}