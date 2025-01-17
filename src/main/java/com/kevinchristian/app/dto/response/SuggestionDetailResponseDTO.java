package com.kevinchristian.app.dto.response;

public record SuggestionDetailResponseDTO(
        String name,
        String latitude,
        String longitude,
        Double score
) {
}