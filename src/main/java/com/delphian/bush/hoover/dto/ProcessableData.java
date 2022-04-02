package com.delphian.bush.hoover.dto;

import com.delphian.bush.hoover.dto.coin_api.ExchangeRate;
import com.delphian.bush.hoover.dto.crypto_panic.CryptoNews;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, defaultImpl = ProcessableData.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExchangeRate.class, name = "ExchangeRate"),

        @JsonSubTypes.Type(value = CryptoNews.class, name = "CryptoNews") }
)
public abstract class ProcessableData {
}
