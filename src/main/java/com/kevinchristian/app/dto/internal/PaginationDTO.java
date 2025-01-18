package com.kevinchristian.app.dto.internal;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PaginationDTO {
    private Integer pageNumber;
    private Integer perPage;
}
