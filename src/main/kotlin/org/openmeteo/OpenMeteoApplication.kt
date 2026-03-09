package org.openmeteo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableCaching
@EnableFeignClients
@SpringBootApplication
class OpenMeteoApplication

fun main(args: Array<String>) {
    runApplication<OpenMeteoApplication>(*args)
}
