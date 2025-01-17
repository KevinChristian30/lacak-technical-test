package com.kevinchristian.app.service;

import com.kevinchristian.app.dto.internal.GeonameCreateDTO;

import java.util.List;

public interface GeonameService {
    void create(List<GeonameCreateDTO> geonameCreateDTOS);
}
