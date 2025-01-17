package com.kevinchristian.app.repository;

import com.kevinchristian.app.entity.Geoname;
import com.kevinchristian.app.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GeonameRepository extends BaseRepository<Geoname, Long> {
    @Modifying
    @Query("DELETE FROM Geoname")
    void batchDelete();
}
