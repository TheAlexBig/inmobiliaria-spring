package com.root.inmobiliaria

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class InmobiliariaApplication
fun main(args: Array<String>) {
    runApplication<InmobiliariaApplication>(*args)
}
