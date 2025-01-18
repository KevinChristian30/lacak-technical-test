package com.kevinchristian.app.service.impl;

import com.kevinchristian.app.domain.query.SuggestionQueryResult;
import com.kevinchristian.app.dto.internal.PaginationDTO;
import com.kevinchristian.app.dto.internal.SuggestionFilterDTO;
import com.kevinchristian.app.dto.response.SuggestionDetailResponseDTO;
import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.mapper.GeonameMapper;
import com.kevinchristian.app.repository.GeonameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SuggestionServiceImplTest {
    @Mock
    private GeonameRepository geonameRepository;

    @Mock
    private GeonameMapper geonameMapper;

    @InjectMocks
    private SuggestionServiceImpl suggestionServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sanityTest() {
        assertTrue(true);
    }

    @Test
    void testListSuggestions() {
        // Arrange
        SuggestionFilterDTO suggestionFilterDTO = new SuggestionFilterDTO(
                "query", 20.0, -20.0, new PaginationDTO(1, 10)
        );
        List<SuggestionQueryResult> mockSuggestions = Arrays.asList(
                new SuggestionQueryResult("London", 1.0, -2.0, 0.6),
                new SuggestionQueryResult("Paris", 3.0, -4.0, 0.5)
        );
        List<SuggestionDetailResponseDTO> mockSuggestionResponseDTOs = Arrays.asList(
                new SuggestionDetailResponseDTO("London", 1.0, -2.0, 0.6),
                new SuggestionDetailResponseDTO("Paris", 3.0, -4.0, 0.5)
        );
        SuggestionListResponseDTO expectedResponseDTO = new SuggestionListResponseDTO(mockSuggestionResponseDTOs);

        Mockito.when(geonameRepository.getSuggestedGeonames(
                suggestionFilterDTO.getQ(),
                suggestionFilterDTO.getLatitude(),
                suggestionFilterDTO.getLongitude(),
                suggestionFilterDTO.getPaginationDTO().getPageNumber(),
                suggestionFilterDTO.getPaginationDTO().getPerPage()
        )).thenReturn(mockSuggestions);
        Mockito.when(geonameMapper.toSuggestionListResponseDTO(mockSuggestions)).thenReturn(expectedResponseDTO);

        // Act
        SuggestionListResponseDTO actualResponseDTO = suggestionServiceImpl.listSuggestions(suggestionFilterDTO);

        // Assert
        assertEquals(expectedResponseDTO, actualResponseDTO);
    }
}
