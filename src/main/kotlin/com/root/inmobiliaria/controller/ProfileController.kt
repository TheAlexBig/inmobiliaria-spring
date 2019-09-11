package com.root.inmobiliaria.controller

import com.root.inmobiliaria.form.ProfileForm
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid


@Controller
class ProfileController{

    @PostMapping("/profile")
    fun profilePost(@Valid @ModelAttribute("profileForm") profile : ProfileForm, model : Model): String {
        return "client/dashboard"
    }
}