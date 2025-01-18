package com.kevinchristian.app.domain.query;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SuggestionQueryResult {
    private String name;
    private Double latitude;
    private Double longitude;
    private Double score;
}
