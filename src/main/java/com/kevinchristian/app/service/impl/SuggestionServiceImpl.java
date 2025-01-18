package com.kevinchristian.app.service.impl;

import com.kevinchristian.app.domain.query.SuggestionQueryResult;
import com.kevinchristian.app.dto.internal.SuggestionFilterDTO;
import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.mapper.GeonameMapper;
import com.kevinchristian.app.repository.GeonameRepository;
import com.kevinchristian.app.service.SuggestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {
    private GeonameRepository geonameRepository;
    private GeonameMapper geonameMapper;

    @Override
    public SuggestionListResponseDTO listSuggestions(SuggestionFilterDTO dto) {
        List<SuggestionQueryResult> suggestions = geonameRepository.getSuggestedGeonames(
                dto.getQ(),
                dto.getLatitude(),
                dto.getLongitude(),
                dto.getPaginationDTO().getPageNumber(),
                dto.getPaginationDTO().getPerPage()
        ).stream().map(result -> (SuggestionQueryResult) result).toList();

//        List<Object> suggestions = geonameRepository.getSuggestedGeonames(
//                dto.getQ(),
//                dto.getLatitude(),
//                dto.getLongitude(),
//                dto.getPaginationDTO().getPageNumber(),
//                dto.getPaginationDTO().getPerPage()
//        );

        return geonameMapper.toSuggestionListResponseDTO(suggestions);
    }

}
