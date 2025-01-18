package com.kevinchristian.app.mock.dto;

import com.kevinchristian.app.constant.ErrorMessage;
import com.kevinchristian.app.dto.internal.PaginationDTO;
import com.kevinchristian.app.dto.internal.SuggestionFilterDTO;

public class MockSuggestionFilterDTO {
    private MockSuggestionFilterDTO() {
        throw new IllegalStateException(ErrorMessage.DO_NOT_INSTANTIATE);
    }

    public static SuggestionFilterDTO mock() {
        return new SuggestionFilterDTO(
                "query", 20.0, -20.0, MockPaginationDTO.mock()
        );
    }
}
