package com.example.application.client;

import com.example.application.model.Forecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ForecastClient {
    @Value("${baseUrl}")
    private String baseUrl;
    private RestTemplate restTemplate;

    public ForecastClient() {
        this.restTemplate = new RestTemplate();
    }

    public Forecast getForecast(String city) {
        String url = baseUrl + "&q=" + city + "&aqi=no";
        Forecast result = restTemplate.getForObject(url, Forecast.class);
        return result;
    }
}
