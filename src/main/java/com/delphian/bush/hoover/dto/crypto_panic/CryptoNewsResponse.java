package com.delphian.bush.hoover.dto.crypto_panic;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoNewsResponse implements Serializable {

    private int count;
    private List<CryptoNews> results;

}