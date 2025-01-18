package com.kevinchristian.app.mock.dto;

import com.kevinchristian.app.constant.ErrorMessage;
import com.kevinchristian.app.dto.internal.GeonameCreateDTO;

import java.util.List;

public class MockGeonameCreateDTO {
    private MockGeonameCreateDTO() {
        throw new IllegalStateException(ErrorMessage.DO_NOT_INSTANTIATE);
    }

    public static GeonameCreateDTO mock() {
        return new GeonameCreateDTO();
    }

    public static List<GeonameCreateDTO> mockList() {
        return List.of(mock(), mock(), mock());
    }
}
