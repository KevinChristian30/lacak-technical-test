package com.kevinchristian.app.web;

import com.kevinchristian.app.dto.internal.GeonameCreateDTO;
import com.kevinchristian.app.mapper.GeonameMapper;
import com.kevinchristian.app.mapper.impl.GeonameMapperImpl;
import com.kevinchristian.app.service.GeonameService;
import com.kevinchristian.app.validation.fileextension.FileExtension;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/geonames")
@AllArgsConstructor
@Validated
public class GeonameController {
    private GeonameService geonameService;
    private GeonameMapper geonameMapper;

    @PostMapping
    public ResponseEntity<Void> createGeonames(
            @FileExtension(
                    message = "Invalid File Extension. Must be .tsv",
                    allow = {"tsv"}
            )
            @RequestParam("file") MultipartFile file
    ) {
        List<GeonameCreateDTO> geonameCreateDTOS = new GeonameMapperImpl().toCreateDTOs(file);
        geonameService.create(geonameCreateDTOS);
        return ResponseEntity.ok().build();
    }
}
