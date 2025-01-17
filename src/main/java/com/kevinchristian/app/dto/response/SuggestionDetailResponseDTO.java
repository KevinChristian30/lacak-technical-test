package com.kevinchristian.app.dto.response;

public record SuggestionDetailResponseDTO(
        String name,
        Double latitude,
        Double longitude,
        Double score
) {
}