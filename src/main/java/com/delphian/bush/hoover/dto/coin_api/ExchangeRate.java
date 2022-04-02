package com.delphian.bush.hoover.dto.coin_api;

import com.delphian.bush.hoover.dto.DataType;
import com.delphian.bush.hoover.dto.ProcessableData;
import com.delphian.bush.hoover.dto.SendableToKafka;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ExchangeRate extends ProcessableData implements Serializable, SendableToKafka {

    private String time;

    @JsonProperty("asset_id_quote")
    @JsonAlias({"assetIdQuote"})
    private String assetIdQuote;

    private String rate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExchangeRate that = (ExchangeRate) o;
        return Objects.equals(time, that.time) && Objects.equals(assetIdQuote, that.assetIdQuote) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, assetIdQuote, rate);
    }

    @Override
    public DataType getDataType() {
        return DataType.COIN_API_STATS;
    }
}
