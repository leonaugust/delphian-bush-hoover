package com.delphian.bush.hoover.config.coin_api;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "coin-api")
@Getter
@Setter
public class CoinApiProperties {

    private String apiKey;
    private String baseUrl;
    private String ratesUrl;

}
