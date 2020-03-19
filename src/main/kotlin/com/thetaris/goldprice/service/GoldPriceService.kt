package com.thetaris.goldprice.service

import com.thetaris.goldprice.config.WsdlProperties
import com.thetaris.goldprice.generated.GetCurrentGoldPrice
import com.thetaris.goldprice.generated.GetCurrentGoldPriceResponse
import org.springframework.oxm.jaxb.Jaxb2Marshaller
import org.springframework.stereotype.Service
import org.springframework.ws.client.core.WebServiceTemplate
import org.springframework.ws.soap.client.core.SoapActionCallback

@Service
class GoldPriceService(
        private val getCurrentGoldPrice: GetCurrentGoldPrice,
        private val wsdlProperties: WsdlProperties,
        marshaller: Jaxb2Marshaller
) {

    private final val webServiceTemplate: WebServiceTemplate = WebServiceTemplate()

    init {
        webServiceTemplate.marshaller = marshaller
        webServiceTemplate.unmarshaller = marshaller
    }

    fun getPrices(): GetCurrentGoldPriceResponse =
            webServiceTemplate.marshalSendAndReceive(wsdlProperties.url, getCurrentGoldPrice, getAction())
                    as GetCurrentGoldPriceResponse

    private fun getAction() = SoapActionCallback(wsdlProperties.action)

}
