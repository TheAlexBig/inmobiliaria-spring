package com.root.inmobiliaria.controller

import com.root.inmobiliaria.domain.auth.User
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.thymeleaf.spring5.util.FieldUtils.hasErrors
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import com.root.inmobiliaria.validator.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import com.root.inmobiliaria.service.auth.interfaces.SecurityService
import com.root.inmobiliaria.service.auth.interfaces.UserService
import org.springframework.stereotype.Controller


@Controller
class UserController {
    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var securityService: SecurityService

    @Autowired
    lateinit var userValidator: UserValidator

    @GetMapping("/registration")
    fun registration(user : User, model: Model): String {
        model.addAttribute("userForm", user)

        return "client/client-registration"
    }

    @PostMapping("/registration")
    fun registration(@ModelAttribute("userForm") userForm: User, bindingResult: BindingResult): String {
        userValidator.validate(userForm, bindingResult)

        if (bindingResult.hasErrors()) {
            return "client/client-registration"
        }

        userService.save(userForm)

        securityService.autoLogin(userForm.username, userForm.password)

        return "redirect:/"
    }

    @GetMapping("/login")
    fun login(model: Model, error: String?, logout: String?): String {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.")

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.")

        return "client/client-login"
    }
    /*
    @GetMapping("/", "/welcome")
    fun welcome(model: Model): String {
        return "welcome"
    }*/
}