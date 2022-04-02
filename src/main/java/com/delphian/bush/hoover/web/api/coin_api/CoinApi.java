package com.delphian.bush.hoover.web.api.coin_api;

import com.delphian.bush.hoover.config.feign.FeignResponseDecoderConfig;
import com.delphian.bush.hoover.dto.coin_api.ExchangeRateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "coinApi", url = "${coin-api.base-url}",
configuration = {FeignResponseDecoderConfig.class})
@Profile("!mock-coin-api")
public interface CoinApi {

    @GetMapping(value = "${coin-api.rates-endpoint}/{currency}", produces = "application/json")
    ExchangeRateResponse getRates(@PathVariable String currency,
                                  @RequestParam String apikey,
                                  @RequestParam(defaultValue = "true") boolean invert);

}
