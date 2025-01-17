package com.kevinchristian.app.service.impl;

import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public SuggestionListResponseDTO listSuggestions() {
        return new SuggestionListResponseDTO(Collections.emptyList());
    }
}
