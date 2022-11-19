package com.shubhajit.springbootsoapcountryclient;

import com.shubhajit.springbootsoapcountryclient.country.GetCountryRequest;
import com.shubhajit.springbootsoapcountryclient.country.GetCountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {

    public GetCountryResponse getCountry(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requesting country data for {}.", country);

        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request,
                        new SoapActionCallback(
                                "http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));
    }

}