package com.thetaris.goldprice;

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
class GoldPriceApplication

fun main(args: Array<String>) {
    runApplication<GoldPriceApplication>(*args)
}
