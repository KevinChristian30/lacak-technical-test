package com.kevinchristian.app.dto.internal;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GeonameCreateDTO {
    private Long id;
    private String name;
    private String ascii;
    private String altName;
    private Double lat;
    private Double longitude;
    private String featClass;
    private String featCode;
    private String country;
    private String cc2;
    private String admin1;
    private String admin2;
    private String admin3;
    private String admin4;
    private Long population;
    private Long elevation;
    private Long dem;
    private String tz;
    private String modifiedAt;
}
