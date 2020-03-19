package com.thetaris.goldprice.api;

import com.thetaris.goldprice.generated.GetCurrentGoldPriceResponse;
import com.thetaris.goldprice.service.GoldPriceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ApiResource {

    private final GoldPriceService goldPriceService;

    public ApiResource(GoldPriceService goldPriceService) {
        this.goldPriceService = goldPriceService;
    }

    @GetMapping
    public List<String> listPrices() {
        GetCurrentGoldPriceResponse response = goldPriceService.getPrices();
        return response.getGetCurrentGoldPriceResult().getString();
    }

}
