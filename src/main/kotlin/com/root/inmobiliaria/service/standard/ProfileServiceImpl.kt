package com.root.inmobiliaria.service.standard

import com.root.inmobiliaria.domain.Profile
import com.root.inmobiliaria.domain.auth.User
import com.root.inmobiliaria.repositories.ProfileRepository
import com.root.inmobiliaria.service.standard.interfaces.ProfileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProfileServiceImpl : ProfileService{

    @Autowired
    lateinit var profileRepository: ProfileRepository

    override fun save(profile: Profile) {
        profileRepository.save(profile)
    }

    override fun findByUser(user: User): Optional<Profile> {
        return profileRepository.findByUser(user)
    }
}