package com.root.inmobiliaria.repository.auth

import com.root.inmobiliaria.domain.auth.Role
import com.root.inmobiliaria.repository.auth.interfaces.RoleRepository
import org.springframework.stereotype.Repository

@Repository
class RoleRepositoryImpl : RoleRepository{
    override fun searchRole(): MutableList<Role> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findAllRole(): MutableList<Role> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateRole() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}