package com.delphian.bush.hoover.service.hoover;

import com.delphian.bush.hoover.dto.crypto_panic.CryptoNews;
import com.delphian.bush.hoover.dto.crypto_panic.CryptoNewsResponse;
import com.delphian.bush.hoover.util.exception.ExceptionMessages;
import com.delphian.bush.hoover.web.api.CryptoPanicApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

/**
 * Is used to hoover current crypto news and send them to Kafka.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NewsHooverServiceImpl extends BasicHooverService<CryptoNews> {

    private final CryptoPanicApi cryptoPanicApi;

    @Value("${crypto-panic-key}")
    private String cryptoPanicKey;

    @EventListener(ApplicationReadyEvent.class)
    @Override
    public void lookupStats() {

        CryptoNewsResponse response = cryptoPanicApi.getNews(cryptoPanicKey, "true");

        if (response == null || CollectionUtils.isEmpty(response.getResults())) {
            throw new RuntimeException(ExceptionMessages.CRYPTO_PANIC_BAD_RESPONSE);
        }

        List<CryptoNews> results = response.getResults();

        if (isKafkaProfileEnabled()) {
            results.stream()
                    .filter(e -> Objects.nonNull(e.getCurrencies()))
                    .forEach(e -> sendToKafkaAndPrint(e, e.getCurrencies().get(0).getCode(), e.getDataType()));
        }

    }

}
