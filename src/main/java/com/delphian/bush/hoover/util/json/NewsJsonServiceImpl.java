package com.delphian.bush.hoover.util.json;

import com.delphian.bush.hoover.dto.crypto_panic.CryptoNewsResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * Information about news with currencies:
 *
 * BTC - 7
 * RUNE - 1
 * ADA - 2
 * ETH - 2
 */
@Service
public class NewsJsonServiceImpl extends JsonToPojoService<CryptoNewsResponse> {

    protected NewsJsonServiceImpl(ObjectMapper objectMapper) throws FileNotFoundException {
        super(ResourceUtils.getFile("classpath:mocked-news.json"), objectMapper,CryptoNewsResponse.class);
    }

}
