package com.kevinchristian.app.service.impl;

import com.kevinchristian.app.dto.internal.GeonameCreateDTO;
import com.kevinchristian.app.entity.Geoname;
import com.kevinchristian.app.mapper.GeonameMapper;
import com.kevinchristian.app.repository.GeonameRepository;
import com.kevinchristian.app.service.GeonameService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GeonameServiceImpl implements GeonameService {
    private GeonameRepository geonameRepository;
    private GeonameMapper geonameMapper;

    @Override
    public void create(List<GeonameCreateDTO> geonameCreateDTOS) {
        List<Geoname> geonames = geonameMapper.toEntities(geonameCreateDTOS);
        geonameRepository.saveAll(geonames);
    }
}
