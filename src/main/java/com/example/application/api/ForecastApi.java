package com.example.application.api;

import com.example.application.client.ForecastClient;
import com.example.application.model.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forecast")
@CrossOrigin
public class ForecastApi {
    private ForecastClient client;

    @Autowired
    public ForecastApi(ForecastClient client) {
        this.client = client;
    }

    @PostMapping("/{city}")
    public ResponseEntity<Forecast> getCurrentForecast(@PathVariable String city) {
        Forecast forecast = client.getForecast(city);
        return new ResponseEntity<>(forecast, HttpStatus.OK);
    }
}
