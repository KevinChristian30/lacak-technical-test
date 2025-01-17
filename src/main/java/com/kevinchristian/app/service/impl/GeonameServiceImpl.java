package com.kevinchristian.app.service.impl;

import com.kevinchristian.app.dto.internal.GeonameCreateDTO;
import com.kevinchristian.app.mapper.GeonameMapper;
import com.kevinchristian.app.repository.GeonameRepository;
import com.kevinchristian.app.service.GeonameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GeonameServiceImpl implements GeonameService {
    private GeonameRepository geonameRepository;
    private GeonameMapper geonameMapper;

    @Transactional
    @Override
    public void replaceDataset(List<GeonameCreateDTO> geonameCreateDTOS) {
        geonameRepository.batchDeleteAll();
        geonameRepository.saveAll(geonameMapper.toEntities(geonameCreateDTOS));
    }
}
