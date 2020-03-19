package com.thetaris.goldprice.config;

import com.thetaris.goldprice.WsdlProperties;
import com.thetaris.goldprice.generated.GetCurrentGoldPrice;
import com.thetaris.goldprice.generated.ObjectFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(WsdlProperties.class)
public class WsdlConfig {

    private final WsdlProperties wsdlProperties;

    public WsdlConfig(WsdlProperties wsdlProperties) {
        this.wsdlProperties = wsdlProperties;
    }

    @Bean
    public ObjectFactory objectFactory() {
        return new ObjectFactory();
    }

    @Bean
    public GetCurrentGoldPrice getCurrentGoldPrice(ObjectFactory objectFactory) {
        GetCurrentGoldPrice request = objectFactory.createGetCurrentGoldPrice();
        request.setUserName(wsdlProperties.getUser());
        request.setPassword(wsdlProperties.getPassword());
        return request;
    }

}
