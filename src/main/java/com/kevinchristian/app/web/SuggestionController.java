package com.kevinchristian.app.web;

import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.security.SuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/suggestions")
@RequiredArgsConstructor
public class SuggestionController {
    private final SuggestionService suggestionService;

    @GetMapping
    public ResponseEntity<SuggestionListResponseDTO> list() {
        return ResponseEntity.ok(suggestionService.listSuggestions());
    }
}
