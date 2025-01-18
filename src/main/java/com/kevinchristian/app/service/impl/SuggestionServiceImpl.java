package com.kevinchristian.app.service.impl;

import com.kevinchristian.app.dto.internal.SuggestionFilterDTO;
import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.service.SuggestionService;
import org.springframework.stereotype.Service;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public SuggestionListResponseDTO listSuggestions(SuggestionFilterDTO suggestionFilterDTO) {
        return null;
    }
}
