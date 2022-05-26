package com.delphian.bush.hoover.web.api;

import com.delphian.bush.hoover.config.feign.FeignResponseDecoderConfig;
import com.delphian.bush.hoover.dto.crypto_panic.CryptoNewsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "coinApi", url = "${crypto-panic-url}",
configuration = {FeignResponseDecoderConfig.class})
@Profile("!mock-crypto-panic")
public interface CryptoPanicApi {

    @GetMapping(value = "${crypto-panic-posts-endpoint}", produces = "application/json")
    CryptoNewsResponse getNews(@RequestParam("auth_token") String authToken,
                               @RequestParam("public") String isPublic);

}
