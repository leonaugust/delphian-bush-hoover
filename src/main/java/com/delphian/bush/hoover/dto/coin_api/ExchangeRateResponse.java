package com.delphian.bush.hoover.dto.coin_api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExchangeRateResponse implements Serializable {

    @JsonProperty("asset_id_base")
    private String assetIdBase;

    private List<ExchangeRate> rates;
}
