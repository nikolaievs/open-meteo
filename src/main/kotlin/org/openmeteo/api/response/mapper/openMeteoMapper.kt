package org.openmeteo.api.response.mapper

import org.openmeteo.api.response.OpenMeteoResponse
import org.openmeteo.domain.Weather
import java.time.ZoneOffset

fun OpenMeteoResponse.toDomain() = Weather(
    lat = latitude,
    lon = longitude,
    source = "openmeteo",
    time = current.time.atOffset(ZoneOffset.ofTotalSeconds(utcOffsetSeconds)),
    temperature = current.temperature.toBigDecimal(),
    windSpeed = current.windSpeed.toBigDecimal(),
)