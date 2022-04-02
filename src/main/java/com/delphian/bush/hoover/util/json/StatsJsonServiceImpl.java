package com.delphian.bush.hoover.util.json;

import com.delphian.bush.hoover.dto.coin_api.ExchangeRateResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

@Service
public class StatsJsonServiceImpl extends JsonToPojoService<ExchangeRateResponse> {

    protected StatsJsonServiceImpl(ObjectMapper objectMapper) throws FileNotFoundException {
        super(ResourceUtils.getFile("classpath:mocked-stats.json"), objectMapper, ExchangeRateResponse.class);
    }
}
