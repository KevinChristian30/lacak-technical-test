package com.kevinchristian.app.web;

import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.security.SuggestionService;
import com.kevinchristian.app.validation.fileextension.FileExtension;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/suggestions")
@AllArgsConstructor
@Validated
public class SuggestionController {
    private SuggestionService suggestionService;

    @GetMapping
    public ResponseEntity<SuggestionListResponseDTO> list() {
        return ResponseEntity.ok(suggestionService.listSuggestions());
    }

    @PostMapping
    public ResponseEntity<Void> createSuggestions(
            @FileExtension(
                    message = "Invalid File Extension. Must be .tsv",
                    allow = {"tsv"}
            )
            @RequestParam("file") MultipartFile file
    ) {
        return ResponseEntity.ok().build();
    }
}
