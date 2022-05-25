package com.example.shopofmusictools;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;



@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class CurrencyRateConfig {

    @Value("${currency.url}")
    private String url;

    public URI getUrl(String ...path) {
        return UriComponentsBuilder.fromHttpUrl(url).pathSegment(path).path("/").build().toUri();
    }

}
