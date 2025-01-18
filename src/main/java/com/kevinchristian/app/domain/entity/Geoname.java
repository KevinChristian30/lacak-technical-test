package com.kevinchristian.app.domain.entity;

import com.kevinchristian.app.domain.entity.base.AbstractBaseEntity;
import com.kevinchristian.app.domain.query.SuggestionQueryResult;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "geonames")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@SqlResultSetMapping(
        name = "SuggestionQueryResultMapping",
        classes = @ConstructorResult(
                targetClass = SuggestionQueryResult.class,
                columns = {
                        @ColumnResult(name = "name", type = String.class),
                        @ColumnResult(name = "latitude", type = Double.class),
                        @ColumnResult(name = "longitude", type = Double.class),
                        @ColumnResult(name = "score", type = Double.class)
                }
        )
)
@NamedNativeQuery(
        name = "GeonameRepository.getSuggestedGeonames",
        query = "SELECT name, latitude, longitude, score FROM get_suggestions(:q, :latitude, :longitude, :pageNumber, :perPage)",
        resultSetMapping = "SuggestionQueryResultMapping"
)
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
