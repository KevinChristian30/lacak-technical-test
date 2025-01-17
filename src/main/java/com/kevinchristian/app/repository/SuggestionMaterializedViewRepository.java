package com.kevinchristian.app.repository;

import com.kevinchristian.app.domain.materializedview.SuggestionMaterializedView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface SuggestionMaterializedViewRepository extends JpaRepository<SuggestionMaterializedView, String> {
    @Modifying
    @Query(value = "REFRESH MATERIALIZED VIEW materialized_view_suggestions", nativeQuery = true)
    void refresh();
}
