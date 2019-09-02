package com.root.inmobiliaria.service.auth

import com.root.inmobiliaria.domain.auth.User
import com.root.inmobiliaria.repositories.UserRepository
import com.root.inmobiliaria.service.auth.interfaces.UserService
import org.springframework.stereotype.Service
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.beans.factory.annotation.Autowired


@Service
class UserServiceImpl : UserService{
    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    override fun save(user: User) {
        user.password=bCryptPasswordEncoder.encode(user.password)
        println(user.toString())
        println("*************")
        println(user.toString())
        //userRepository.save(user)
    }

    override fun findByUsername(username: String): User {
        return userRepository.findByUsername(username)
    }

}