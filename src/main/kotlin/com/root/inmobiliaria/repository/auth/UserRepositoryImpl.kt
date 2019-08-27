package com.root.inmobiliaria.repository.auth

import com.root.inmobiliaria.domain.auth.User
import com.root.inmobiliaria.repository.auth.interfaces.UserRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional;

@Repository
class UserRepositoryImpl : UserRepository{
    override fun save(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Transactional
    override fun findByUsername(username: String): User {
        return User()
    }
}