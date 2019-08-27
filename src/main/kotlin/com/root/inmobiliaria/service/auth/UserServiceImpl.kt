package com.root.inmobiliaria.service.auth

import com.root.inmobiliaria.domain.auth.User
import com.root.inmobiliaria.repository.auth.RoleRepositoryImpl
import com.root.inmobiliaria.repository.auth.UserRepositoryImpl
import com.root.inmobiliaria.service.auth.interfaces.UserService
import org.springframework.stereotype.Service
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.beans.factory.annotation.Autowired
import java.util.HashSet

@Service
class UserServiceImpl : UserService{
    @Autowired
    lateinit var userRepository: UserRepositoryImpl
    @Autowired
    lateinit var roleRepository: RoleRepositoryImpl
    @Autowired
    lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    override fun save(user: User) {
        user.password=bCryptPasswordEncoder.encode(user.password)
        user.roles= HashSet(roleRepository.findAllRole())
        userRepository.save(user)
    }

    override fun findByUsername(username: String): User {
        return userRepository.findByUsername(username)
    }

}