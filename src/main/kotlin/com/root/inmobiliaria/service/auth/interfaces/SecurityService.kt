package com.root.inmobiliaria.service.auth.interfaces

interface SecurityService {
    fun findLoggedInUsername(): String

    fun autoLogin(username: String, password: String)
}