package com.root.inmobiliaria.repository.auth.interfaces

import com.root.inmobiliaria.domain.auth.Role

interface RoleRepository {
    fun searchRole() : MutableList<Role>
    fun findAllRole() : MutableList<Role>
    fun updateRole()
}