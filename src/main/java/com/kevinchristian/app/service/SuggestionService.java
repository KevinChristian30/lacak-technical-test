package com.kevinchristian.app.service;

import com.kevinchristian.app.dto.internal.SuggestionFilterDTO;
import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;

public interface SuggestionService {
    SuggestionListResponseDTO listSuggestions(SuggestionFilterDTO suggestionFilterDTO);
}
