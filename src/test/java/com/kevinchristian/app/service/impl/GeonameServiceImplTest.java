package com.kevinchristian.app.service.impl;

import com.kevinchristian.app.dto.internal.GeonameCreateDTO;
import com.kevinchristian.app.mapper.GeonameMapper;
import com.kevinchristian.app.repository.GeonameRepository;
import com.kevinchristian.app.repository.SuggestionMaterializedViewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeonameServiceImplTest {
    @Mock
    private GeonameRepository geonameRepository;

    @Mock
    private SuggestionMaterializedViewRepository suggestionMaterializedViewRepository;

    @Mock
    private GeonameMapper geonameMapper;

    @InjectMocks
    private GeonameServiceImpl geonameService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSanity() {
        assertTrue(true);
    }

    @Test
    void testReplaceDataSet() {
        // Arrange
        List<GeonameCreateDTO> geonameCreateDTOS = List.of(
                new GeonameCreateDTO(),
                new GeonameCreateDTO(),
                new GeonameCreateDTO()
        );

        // Act
        geonameService.replaceDataset(geonameCreateDTOS);

        // Assert
        Mockito.verify(geonameRepository, Mockito.times(1)).batchDeleteAll();
        Mockito.verify(geonameMapper, Mockito.times(1)).toEntities(geonameCreateDTOS);
        Mockito.verify(geonameRepository, Mockito.times(1)).saveAll(Mockito.anyList());
        Mockito.verify(suggestionMaterializedViewRepository, Mockito.times(1)).refresh();
    }
}
