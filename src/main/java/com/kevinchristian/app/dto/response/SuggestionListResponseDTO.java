package com.kevinchristian.app.dto.response;

import java.util.List;

public record SuggestionListResponseDTO(
        List<SuggestionDetailResponseDTO> suggestions
) {
}
