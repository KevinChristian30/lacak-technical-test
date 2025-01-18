package com.kevinchristian.app.service.impl;

import com.kevinchristian.app.domain.query.SuggestionQueryResult;
import com.kevinchristian.app.dto.internal.SuggestionFilterDTO;
import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;
import com.kevinchristian.app.mapper.GeonameMapper;
import com.kevinchristian.app.mock.domain.query.MockSuggestionQueryResult;
import com.kevinchristian.app.mock.dto.MockSuggestionFilterDTO;
import com.kevinchristian.app.mock.dto.MockSuggestionListResponseDTO;
import com.kevinchristian.app.repository.GeonameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
        SuggestionFilterDTO suggestionFilterDTO = MockSuggestionFilterDTO.mock();
        List<SuggestionQueryResult> mockSuggestions = MockSuggestionQueryResult.mockList();
        SuggestionListResponseDTO expectedResponseDTO = MockSuggestionListResponseDTO.mock();

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
