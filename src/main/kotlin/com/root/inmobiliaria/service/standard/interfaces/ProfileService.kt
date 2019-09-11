package com.root.inmobiliaria.service.standard.interfaces

import com.root.inmobiliaria.domain.Profile
import com.root.inmobiliaria.domain.auth.User
import java.util.*

interface ProfileService {
    fun save(profile: Profile)
    fun findByUser(user: User) : Optional<Profile>
}