package com.kevinchristian.app.service.impl;

import com.kevinchristian.app.dto.response.SuggestionDetailResponseDTO;
import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.service.SuggestionService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SuggestionServiceImpl implements SuggestionService {

    @Override
    public SuggestionListResponseDTO listSuggestions(String q, Double latitude, Double longitude) {
        return new SuggestionListResponseDTO(
                Collections.singletonList(
                        new SuggestionDetailResponseDTO(
                                q, latitude, longitude, (double) 0
                        )
                )
        );
    }
}
