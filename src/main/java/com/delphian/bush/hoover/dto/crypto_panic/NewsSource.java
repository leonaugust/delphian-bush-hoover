package com.delphian.bush.hoover.dto.crypto_panic;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsSource {

    private String title;
    private String region;
    private String domain;
    private String path;

}
