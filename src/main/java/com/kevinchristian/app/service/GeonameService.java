package com.kevinchristian.app.service;

import com.kevinchristian.app.dto.internal.GeonameCreateDTO;

import java.util.List;

public interface GeonameService {
    void replaceDataset(List<GeonameCreateDTO> geonameCreateDTOS);
}
