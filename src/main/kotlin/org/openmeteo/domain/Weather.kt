package org.openmeteo.domain

import java.math.BigDecimal
import java.time.OffsetDateTime

data class Weather(
    val lat: BigDecimal,
    val lon: BigDecimal,
    val source: String,
    val time: OffsetDateTime,
    val temperature: BigDecimal,
    val windSpeed: BigDecimal,
)