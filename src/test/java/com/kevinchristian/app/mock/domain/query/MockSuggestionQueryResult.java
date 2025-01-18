package com.kevinchristian.app.mock.domain.query;

import com.kevinchristian.app.constant.ErrorMessage;
import com.kevinchristian.app.domain.query.SuggestionQueryResult;

import java.util.List;

public class MockSuggestionQueryResult {
    private MockSuggestionQueryResult() {
        throw new IllegalStateException(ErrorMessage.DO_NOT_INSTANTIATE);
    }

    public static SuggestionQueryResult mock() {
        return new SuggestionQueryResult("London", 1.0, -2.0, 0.6);
    }

    public static List<SuggestionQueryResult> mockList() {
        return List.of(mock(), mock(), mock());
    }
}
