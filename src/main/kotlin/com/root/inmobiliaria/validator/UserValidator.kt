package com.root.inmobiliaria.validator

import com.root.inmobiliaria.domain.auth.User
import com.root.inmobiliaria.form.UserForm
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Errors
import com.root.inmobiliaria.service.auth.interfaces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.Validator


@Component
class UserValidator : Validator {
    @Autowired
    lateinit var userService: UserService

    override fun supports(aClass: Class<*>): Boolean {
        return User::class.java == aClass
    }

    override fun validate(o: Any, errors: Errors) {
        val user = o as UserForm

        val foundUser = userService.findByUsernameOrEmail(user.username, user.email)
        if (foundUser.isPresent) {
            if(foundUser.get().username == user.username)
                errors.rejectValue("username", "Duplicate.userForm.username", "El nombre de usuario ya esta en uso")
            if(foundUser.get().email == user.email)
                errors.rejectValue("email", "Duplicate.userForm.email", "El correo ingresado ya se encuentra vinculado en la plataforma")
        }

        if (user.passwordConfirm != user.password) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm", "Las contraseñas no coinciden")
        }
    }
}