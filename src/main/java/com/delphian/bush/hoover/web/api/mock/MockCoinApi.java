package com.delphian.bush.hoover.web.api.mock;

import com.delphian.bush.hoover.dto.coin_api.ExchangeRateResponse;
import com.delphian.bush.hoover.util.json.JsonToPojoService;
import com.delphian.bush.hoover.web.api.CoinApi;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("mock-coin-api")
@Service
@RequiredArgsConstructor
public class MockCoinApi implements CoinApi {

    @Qualifier("statsJsonServiceImpl")
    private final JsonToPojoService<ExchangeRateResponse> currencyJsonToPojoService;

    @Override
    public ExchangeRateResponse getRates(String currency, String apikey, boolean invert) {
        return currencyJsonToPojoService.getFromJson();
    }
}
