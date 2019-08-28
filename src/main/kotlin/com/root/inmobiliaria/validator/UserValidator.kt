package com.root.inmobiliaria.validator

import com.root.inmobiliaria.domain.auth.User
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
        val user = o as User

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty")
        if (user.username.length < 6 || user.username.length > 32) {
            errors.rejectValue("username", "Size.userForm.username")
        }

        val foundUser = userService.findByUsername(user.username)

        if (foundUser == user) {
            errors.rejectValue("username", "Duplicate.userForm.username")
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty")
        if (user.password.length < 8 || user.password.length > 32) {
            errors.rejectValue("password", "Size.userForm.password")
        }

        if (user.passwordConfirm != user.password) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm")
        }
    }
}