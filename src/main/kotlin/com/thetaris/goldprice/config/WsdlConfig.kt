package com.thetaris.goldprice.config

import com.thetaris.goldprice.generated.GetCurrentGoldPrice
import com.thetaris.goldprice.generated.ObjectFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.validation.constraints.NotNull

@Configuration
class WsdlConfig(private val wsdlProperties: WsdlProperties) {

    @Bean
    fun getCurrentGoldPrice(): GetCurrentGoldPrice {
        val request: GetCurrentGoldPrice = ObjectFactory().createGetCurrentGoldPrice()
        request.userName = wsdlProperties.user
        request.password = wsdlProperties.password
        return request
    }

}

@Configuration
@ConfigurationProperties(prefix = "wsdl")
class WsdlProperties {

    @NotNull
    lateinit var url: String

    @NotNull
    lateinit var action: String

    @NotNull
    lateinit var user: String

    @NotNull
    lateinit var password: String

}
