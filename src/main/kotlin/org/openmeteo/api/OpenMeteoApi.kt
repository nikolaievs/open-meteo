package org.openmeteo.api

import org.openmeteo.api.response.OpenMeteoResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.math.BigDecimal

@FeignClient(name = "openmeteo", url = "\${config.openmeteo.url}/v1")
interface OpenMeteoApi {

    @GetMapping("/forecast")
    fun forecast(
        @RequestParam longitude: BigDecimal,
        @RequestParam latitude: BigDecimal,
        @RequestParam current: List<String> = listOf("temperature_2m", "wind_speed_10m")
    ): OpenMeteoResponse
}