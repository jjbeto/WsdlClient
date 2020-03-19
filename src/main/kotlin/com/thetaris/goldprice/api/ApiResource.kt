package com.thetaris.goldprice.api

import com.thetaris.goldprice.generated.GetCurrentGoldPriceResponse
import com.thetaris.goldprice.service.GoldPriceService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class ApiResource(val goldPriceService: GoldPriceService) {

    @GetMapping
    fun listPrices(): MutableList<String> {
        val response: GetCurrentGoldPriceResponse = goldPriceService.getPrices()
        return response.getCurrentGoldPriceResult.string
    }

}
