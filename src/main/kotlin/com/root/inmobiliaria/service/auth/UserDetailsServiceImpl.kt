package com.root.inmobiliaria.service.auth

import com.root.inmobiliaria.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Primary

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.HashSet
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

@Primary
@Service
class UserDetailsServiceImpl : UserDetailsService{

    @Autowired
    lateinit var userRepositoryImpl: UserRepository

    @Transactional(readOnly = true)
    override fun loadUserByUsername( Username: String): UserDetails{
        val user = userRepositoryImpl.findByEmail(Username)

        val grantedAuthorities = HashSet<GrantedAuthority>()
        if(user.isPresent){
            if(user.get().accountType==1) {
                grantedAuthorities.add(SimpleGrantedAuthority("visual"))
            }
            return org.springframework.security.core.userdetails.User(user.get().username, user.get().password, grantedAuthorities)
        }
        else{
            throw UsernameNotFoundException(Username)
        }
    }
}