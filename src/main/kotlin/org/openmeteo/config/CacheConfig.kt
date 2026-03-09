package org.openmeteo.config

import com.hazelcast.spring.cache.HazelcastCacheManager
import com.hazelcast.config.Config
import com.hazelcast.config.MapConfig
import com.hazelcast.core.Hazelcast
import com.hazelcast.core.HazelcastInstance
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration


@Configuration
class CacheConfig {

    @Bean
    fun hazelcastInstance(config: Config): HazelcastInstance = Hazelcast.newHazelcastInstance(config)

    @Bean
    fun config(
        @Value("\${config.caches.weather.ttl:60S}") weatherTtl: Duration,
    ) = Config().apply {
        addMapConfig(MapConfig("weather").setTimeToLiveSeconds(weatherTtl.seconds.toInt()))
    }

    @Bean
    fun cacheManager(hazelcastInstance: HazelcastInstance) = HazelcastCacheManager(hazelcastInstance)
}