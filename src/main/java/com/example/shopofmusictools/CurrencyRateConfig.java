package com.example.shopofmusictools;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;



@Configuration
public class CurrencyRateConfig {

    private String url = "${currency.url}";

    public URI getUrl(String ...path) {
        return UriComponentsBuilder.fromHttpUrl(url).pathSegment(path).path("/").build().toUri();
    }

}
