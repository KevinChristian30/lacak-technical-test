package com.kevinchristian.app.repository;

import com.kevinchristian.app.domain.entity.Geoname;
import com.kevinchristian.app.domain.query.SuggestionQueryResult;
import com.kevinchristian.app.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeonameRepository extends BaseRepository<Geoname, Long> {
    @Modifying
    @Query("DELETE FROM Geoname")
    void batchDeleteAll();

    @Query(name = "GeonameRepository.getSuggestedGeonames", nativeQuery = true)
    List<SuggestionQueryResult> getSuggestedGeonames(
            @Param("q") String q,
            @Param("latitude") Double latitude,
            @Param("longitude") Double longitude,
            @Param("pageNumber") Integer pageNumber,
            @Param("perPage") Integer perPage
    );
}
