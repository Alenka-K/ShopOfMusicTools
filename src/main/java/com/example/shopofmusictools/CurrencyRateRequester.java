package com.example.shopofmusictools;


import com.example.shopofmusictools.models.Tool;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Component
public class CurrencyRateRequester {
    private static final Logger logger = Logger.getLogger(CurrencyRateRequester.class);
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    private final CurrencyRateConfig currencyRateConfig;

    public CurrencyRateRequester(CurrencyRateConfig currencyRateConfig) {
        this.currencyRateConfig = currencyRateConfig;
    }


    public float getCurrencyRate(Tool tool) {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(currencyRateConfig.getUrl(tool.getCurrency(), LocalDate.now().format(DATE_FORMATTER))).build();
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
                logger.error("Currency rate was not received", e);
            }
            return 0.0f;
        }

}
