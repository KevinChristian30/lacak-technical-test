package com.kevinchristian.app.domain.materializedview;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "materialized_view_suggestions")
@Immutable
@Getter
@AllArgsConstructor
public class SuggestionMaterializedView implements Serializable {
    @Serial
    private static final long serialVersionUID = 2960796657626478708L;

    @Id
    @Column(name = "secure_id", length = 36)
    private String secureId;

    @Column(name = "query", length = 6000)
    private String query;

    @Column(name = "name")
    private String name;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "long")
    private Double longitude;
}
