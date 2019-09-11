package com.root.inmobiliaria.repositories

import com.root.inmobiliaria.domain.Profile
import com.root.inmobiliaria.domain.auth.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

import java.util.*

@Service
interface ProfileRepository :  CrudRepository<Profile, UUID>{
    fun findByUser(user: User) : Optional<Profile>
}