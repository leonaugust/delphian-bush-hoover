package com.delphian.bush.hoover.web.api.mock;

import com.delphian.bush.hoover.dto.crypto_panic.CryptoNewsResponse;
import com.delphian.bush.hoover.util.json.JsonToPojoService;
import com.delphian.bush.hoover.web.api.CryptoPanicApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("mock-crypto-panic")
@Service
@RequiredArgsConstructor
public class MockCryptoPanicApi implements CryptoPanicApi {

    @Qualifier("newsJsonServiceImpl")
    private final JsonToPojoService<CryptoNewsResponse> newsJsonToPojoService;

    @Override
    public CryptoNewsResponse getNews(String authToken, String isPublic) {
        return newsJsonToPojoService.getFromJson();
    }
}
