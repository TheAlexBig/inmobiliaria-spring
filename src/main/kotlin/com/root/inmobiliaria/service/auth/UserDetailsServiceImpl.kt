package com.root.inmobiliaria.service.auth

import com.root.inmobiliaria.repository.auth.UserRepositoryImpl
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.HashSet
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetailsService


@Service
class UserDetailsServiceImpl : UserDetailsService{

    @Autowired
    lateinit var userRepositoryImpl: UserRepositoryImpl

    @Transactional(readOnly = true)
    override fun loadUserByUsername( Username: String): UserDetails{
        val user = userRepositoryImpl.findByUsername(Username)

        val grantedAuthorities = HashSet<GrantedAuthority>()
        if(user.roles != null) {
            for (role in user.roles!!) {
                grantedAuthorities.add(SimpleGrantedAuthority(role.name))
            }
        }
        return org.springframework.security.core.userdetails.User(user.username, user.password, grantedAuthorities)
    }
}