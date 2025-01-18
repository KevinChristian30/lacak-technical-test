package com.kevinchristian.app.mock.dto;

import com.kevinchristian.app.constant.ErrorMessage;
import com.kevinchristian.app.dto.response.SuggestionListResponseDTO;

public class MockSuggestionListResponseDTO {
    private MockSuggestionListResponseDTO() {
        throw new IllegalStateException(ErrorMessage.DO_NOT_INSTANTIATE);
    }

    public static SuggestionListResponseDTO mock() {
        return new SuggestionListResponseDTO(MockSuggestionDetailResponseDTO.mockList());
    }
}
