package com.delphian.bush.hoover.service.hoover;

import com.delphian.bush.hoover.config.coin_api.CoinApiProperties;
import com.delphian.bush.hoover.dto.coin_api.ExchangeRate;
import com.delphian.bush.hoover.dto.coin_api.ExchangeRateResponse;
import com.delphian.bush.hoover.util.exception.ExceptionMessages;
import com.delphian.bush.hoover.web.api.coin_api.CoinApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Is used to hoover current crypto exchange rates and send them to Kafka.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class StatsHooverServiceImpl extends BasicHooverService<ExchangeRate> {

    private final CoinApiProperties apiProperties;
    private final CoinApi coinApi;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void lookupStats() {

        ExchangeRateResponse response = coinApi.getRates(USD, apiProperties.getApiKey(), INVERT);
        if (response == null || CollectionUtils.isEmpty(response.getRates())) {
            throw new RuntimeException(ExceptionMessages.COIN_API_BAD_RESPONSE);
        }

        List<ExchangeRate> rates = response.getRates();

        if (isKafkaProfileEnabled()) {
            rates.forEach(e -> sendToKafkaAndPrint(e, e.getAssetIdQuote(), e.getDataType()));
        }
    }

}
