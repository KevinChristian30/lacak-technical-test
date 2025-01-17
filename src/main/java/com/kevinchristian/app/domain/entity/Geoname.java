package com.kevinchristian.app.domain.entity;

import com.kevinchristian.app.domain.entity.base.AbstractBaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "geonames")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Geoname extends AbstractBaseEntity {
    @Column(name = "geoname_id")
    private Long geonameId;

    @Column(name = "name")
    private String name;

    @Column(name = "ascii")
    private String ascii;

    @Column(name = "alt_name", length = 5000)
    private String altName;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "long")
    private Double longitude;

    @Column(name = "feat_class")
    private String featClass;

    @Column(name = "feat_code")
    private String featCode;

    @Column(name = "country")
    private String country;

    @Column(name = "cc2")
    private String cc2;

    @Column(name = "admin1")
    private String admin1;

    @Column(name = "admin2")
    private String admin2;

    @Column(name = "admin3")
    private String admin3;

    @Column(name = "admin4")
    private String admin4;

    @Column(name = "population")
    private Long population;

    @Column(name = "elevation")
    private Long elevation;

    @Column(name = "dem")
    private Long dem;

    @Column(name = "tz")
    private String tz;
}
