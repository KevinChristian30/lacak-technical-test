package com.kevinchristian.app.service;

import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;

public interface SuggestionService {
    SuggestionListResponseDTO listSuggestions(String q, Double latitude, Double longitude);
}
