package com.root.inmobiliaria

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.thymeleaf.templatemode.TemplateMode
import org.dom4j.dom.DOMNodeHelper.setPrefix
import org.springframework.context.annotation.ComponentScan
import org.springframework.web.server.adapter.WebHttpHandlerBuilder.applicationContext
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver
import org.thymeleaf.templateresolver.ITemplateResolver
import org.thymeleaf.spring5.SpringTemplateEngine
import org.thymeleaf.TemplateEngine
import org.thymeleaf.spring5.view.ThymeleafViewResolver
import org.springframework.web.servlet.ViewResolver
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext


@EnableWebMvc
@Configuration
@ComponentScan
class WebConfig: WebMvcConfigurer {
    @Autowired
    lateinit var applicationContext: ApplicationContext


    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler(
                "/assets/**"
        ).addResourceLocations(
                "classpath:/static/assets/"
        )
    }


/*
    @Bean
    fun templateEngine(): SpringTemplateEngine {
        val templateEngine = SpringTemplateEngine()
        templateEngine.setTemplateResolver(templateResolver())
        return templateEngine
    }

    @Bean
    fun templateResolver(): SpringResourceTemplateResolver {
        val templateResolver = SpringResourceTemplateResolver()
        templateResolver.setApplicationContext(this.applicationContext)
        templateResolver.prefix = "/templates/"
        templateResolver.suffix = ".html"
        return templateResolver
    }

    @Bean
    fun viewResolver(): ViewResolver {
        val viewResolver = ThymeleafViewResolver()
        viewResolver.templateEngine = templateEngine()
        return viewResolver
    }*/
}