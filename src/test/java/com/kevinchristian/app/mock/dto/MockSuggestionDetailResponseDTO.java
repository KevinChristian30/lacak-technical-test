package com.kevinchristian.app.mock.dto;

import com.kevinchristian.app.constant.ErrorMessage;
import com.kevinchristian.app.dto.response.SuggestionDetailResponseDTO;

import java.util.List;

public class MockSuggestionDetailResponseDTO {
    private MockSuggestionDetailResponseDTO() {
        throw new IllegalStateException(ErrorMessage.DO_NOT_INSTANTIATE);
    }

    public static SuggestionDetailResponseDTO mock() {
        return new SuggestionDetailResponseDTO("London", 1.0, -2.0, 0.6);
    }

    public static List<SuggestionDetailResponseDTO> mockList() {
        return List.of(mock(), mock(), mock());
    }
}
