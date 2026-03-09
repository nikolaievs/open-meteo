package org.openmeteo.service

import org.openmeteo.api.OpenMeteoApi
import org.openmeteo.api.response.mapper.toDomain
import org.openmeteo.domain.Weather
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class WeatherService(
    private val openMeteoApi: OpenMeteoApi
) {

    @Cacheable("weather")
    fun getWeather(
        lon: BigDecimal,
        lat: BigDecimal
    ): Weather = openMeteoApi.forecast(lon, lat).toDomain()
}