package com.kevinchristian.app.web;

import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.service.SuggestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/suggestions")
@AllArgsConstructor
@Validated
public class SuggestionController {
    private SuggestionService suggestionService;

    @GetMapping
    public ResponseEntity<SuggestionListResponseDTO> list(
            @RequestParam(value = "q", required = true) String q,
            @RequestParam(value = "latitude", required = false) Double latitude,
            @RequestParam(value = "longitude", required = false) Double longitude
    ) {
        return ResponseEntity.ok(suggestionService.listSuggestions(q, latitude, longitude));
    }
}
