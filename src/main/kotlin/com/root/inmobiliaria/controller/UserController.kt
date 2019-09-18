package com.root.inmobiliaria.controller

import com.root.inmobiliaria.domain.auth.User
import com.root.inmobiliaria.form.ProfileForm
import com.root.inmobiliaria.form.UserForm
import com.root.inmobiliaria.service.auth.SecurityServiceImpl
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import com.root.inmobiliaria.validator.UserValidator
import org.springframework.beans.factory.annotation.Autowired
import com.root.inmobiliaria.service.auth.interfaces.UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
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
    fun registration(userForm : UserForm, model: Model): String {

        model.addAttribute("userForm", userForm)

        return "client/registration"
    }

    @PostMapping("/registration")
    fun registration(@Valid @ModelAttribute("userForm") userForm: UserForm, profile : ProfileForm,
                     bindingResult: BindingResult, model : Model): String {
        val user = User()
        user.password = userForm.password
        user.username = userForm.username
        user.email = userForm.email

        userValidator.validate(userForm, bindingResult)

        if (bindingResult.hasErrors()) {
            return "client/registration"
        }
        userService.save(user)
        securityService.autoLogin(userForm.username, userForm.password)

        model.addAttribute("user", user)
        model.addAttribute("profileForm", profile)
        return "client/dashboard"
    }

    @GetMapping("/login")
    fun login(model: Model, error: String?, logout: String?): String {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.")

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.")

        return "client/login"
    }

    @RequestMapping("/dashboard", method = [RequestMethod.POST, RequestMethod.GET])
    fun welcomeClient(profile : ProfileForm, model: Model): String {

        val username = securityService.findLoggedInUsername()

        if(username !="not-found"){
            val result = userService.findByUsername(username)
            if(result.isPresent){
                model.addAttribute("user", result.get())
                model.addAttribute("profileForm", profile)
                return "client/dashboard"
            }
        }
        return "redirect:/login"
    }
}