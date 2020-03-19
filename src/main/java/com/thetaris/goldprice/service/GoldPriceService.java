package com.thetaris.goldprice.service;

import com.thetaris.goldprice.WsdlProperties;
import com.thetaris.goldprice.generated.GetCurrentGoldPrice;
import com.thetaris.goldprice.generated.GetCurrentGoldPriceResponse;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Service
public class GoldPriceService {

    private final WebServiceTemplate webServiceTemplate;

    private final GetCurrentGoldPrice getCurrentGoldPrice;

    private final WsdlProperties wsdlProperties;

    public GoldPriceService(GetCurrentGoldPrice getCurrentGoldPrice, WsdlProperties wsdlProperties, Jaxb2Marshaller marshaller) {
        this.getCurrentGoldPrice = getCurrentGoldPrice;
        this.wsdlProperties = wsdlProperties;

        webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);
    }

    public GetCurrentGoldPriceResponse getPrices() {
        return (GetCurrentGoldPriceResponse) webServiceTemplate
                .marshalSendAndReceive(
                        wsdlProperties.getUrl(),
                        getCurrentGoldPrice,
                        new SoapActionCallback(wsdlProperties.getAction()));
    }

}
