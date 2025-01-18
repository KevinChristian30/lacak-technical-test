package com.kevinchristian.app.dto.internal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SuggestionFilterDTO {
    private String q;
    private Double latitude;
    private Double longitude;
    private PaginationDTO paginationDTO;
}
