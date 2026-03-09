package org.openmeteo.domain.mapper

import org.openmeteo.domain.Weather
import org.openmeteo.response.WeatherResponse

fun Weather.toResponse() = WeatherResponse(
    location = WeatherResponse.Location(lat, lon),
    source = source,
    retrievedAt = time,
    current = WeatherResponse.Current(temperature, windSpeed)
)