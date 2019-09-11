package com.root.inmobiliaria.controller

import com.root.inmobiliaria.domain.auth.User
import com.root.inmobiliaria.form.ClientForm
import com.root.inmobiliaria.form.UserForm
import com.root.inmobiliaria.service.auth.SecurityServiceImpl
import org.springframework.ui.Model
import org.thymeleaf.spring5.util.FieldUtils.hasErrors
import org.springframework.validation.BindingResult
import com.root.inmobiliaria.validator.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import com.root.inmobiliaria.service.auth.interfaces.SecurityService
import com.root.inmobiliaria.service.auth.interfaces.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.security.Principal
import javax.validation.Valid


@Controller
class UserController {
    @Autowired
    lateinit var userService: UserService

    @Autowired
    lateinit var securityService: SecurityServiceImpl

    @Autowired
    lateinit var userValidator: UserValidator


    @GetMapping("/registration")
    fun registration(user : UserForm, model: Model): String {
        model.addAttribute("userForm", user)

        return "client/client-registration"
    }

    @PostMapping("/registration")
    fun registration(@Valid @ModelAttribute("userForm") userForm: UserForm,
                     bindingResult: BindingResult): String {
        val user = User()
        user.password = userForm.password
        user.username = userForm.username
        user.email = userForm.email

        userValidator.validate(userForm, bindingResult)

        if (bindingResult.hasErrors()) {
            return "client/client-registration"
        }
        userService.save(user)
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
    @RequestMapping("/dashboard", method = [RequestMethod.GET, RequestMethod.POST])
    fun welcomeClient(model: Model, principal: Principal) : String {


        return "client/welcome-dashboard"
    }
}