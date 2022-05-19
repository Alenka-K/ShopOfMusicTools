package com.example.shopofmusictools;


import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CurrencyRateRequester {
    private static final Logger logger = Logger.getLogger(CurrencyRateRequester.class);
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private static final String URL = "http://java-lab3:8787/";

        public static float getCurrencyRate(String currencyCode) {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL + currencyCode + "/" + DATE_FORMATTER.format(LocalDate.now()))).build();
            HttpResponse<String> response;

            try {
                logger.info("Getting the exchange rate");
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response != null) {
                    float rate = Float.parseFloat(response.body());
                    logger.info("exchange rate: " + rate);
                    return rate;
                }
            } catch (IOException | InterruptedException e) {
                logger.error(e.getStackTrace());
                logger.info("Current rate did not receive");
            }
            return 0.0f;
        }
}
