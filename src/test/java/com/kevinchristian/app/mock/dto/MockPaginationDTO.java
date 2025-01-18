package com.kevinchristian.app.mock.dto;

import com.kevinchristian.app.constant.ErrorMessage;
import com.kevinchristian.app.dto.internal.PaginationDTO;

public class MockPaginationDTO {
    private MockPaginationDTO() {
        throw new IllegalStateException(ErrorMessage.DO_NOT_INSTANTIATE);
    }

    public static PaginationDTO mock() {
        return new PaginationDTO(1, 10);
    }
}
