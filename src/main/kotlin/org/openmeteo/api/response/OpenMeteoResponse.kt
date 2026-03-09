package org.openmeteo.api.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDateTime

data class OpenMeteoResponse(
    val latitude: BigDecimal,
    val longitude: BigDecimal,
    @JsonProperty("generationtime_ms") val generationTime: BigDecimal,
    @JsonProperty("utc_offset_seconds") val utcOffsetSeconds: Int,
    @JsonProperty("timezone") val timezone: String,
    @JsonProperty("timezone_abbreviation") val timezoneAbbreviation: String,
    @JsonProperty("elevation") val elevation: BigDecimal,
    @JsonProperty("current_units") val units: Units,
    val current: Current,
) {
    data class Units(
        @JsonProperty("time") val time: String,
        @JsonProperty("interval") val interval: String,
        @JsonProperty("temperature_2m") val temperature: String,
        @JsonProperty("wind_speed_10m") val windSpeed: String,
    )

    data class Current(
        val time: LocalDateTime,
        val interval: Long,
        @JsonProperty("temperature_2m") val temperature: Double,
        @JsonProperty("wind_speed_10m") val windSpeed: Double,
    )
}