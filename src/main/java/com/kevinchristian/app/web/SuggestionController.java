package com.kevinchristian.app.web;

import com.kevinchristian.app.dto.internal.GeonameCreateDTO;
import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.mapper.GeonameMapper;
import com.kevinchristian.app.mapper.impl.GeonameMapperImpl;
import com.kevinchristian.app.security.SuggestionService;
import com.kevinchristian.app.validation.fileextension.FileExtension;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/suggestions")
@AllArgsConstructor
@Validated
@Slf4j
public class SuggestionController {
    private SuggestionService suggestionService;
    private GeonameMapper geonameMapper;

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
        List<GeonameCreateDTO> geonames = new GeonameMapperImpl().toCreateDTOs(file);
        log.info(String.valueOf(geonames.size()));
        return ResponseEntity.ok().build();
    }
}
