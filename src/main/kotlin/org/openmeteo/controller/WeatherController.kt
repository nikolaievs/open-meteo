package org.openmeteo.controller

import org.openmeteo.domain.mapper.toResponse
import org.openmeteo.response.WeatherResponse
import org.openmeteo.service.WeatherService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/v1/weather")
class WeatherController(
    private val weatherService: WeatherService,
) {

    @GetMapping
    fun getWeather(
        @RequestParam lon: BigDecimal,
        @RequestParam lat: BigDecimal
    ): WeatherResponse = weatherService.getWeather(lon, lat).toResponse()
}