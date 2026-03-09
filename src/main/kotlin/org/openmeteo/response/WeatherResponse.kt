package org.openmeteo.response

import java.math.BigDecimal
import java.time.OffsetDateTime

data class WeatherResponse(
    val location: Location,
    val current: Current,
    val source: String,
    val retrievedAt: OffsetDateTime,
) {
    data class Location(
        val lat: BigDecimal,
        val lon: BigDecimal
    )

    data class Current(
        val temperatureC: BigDecimal,
        val windSpeedKmh: BigDecimal
    )
}