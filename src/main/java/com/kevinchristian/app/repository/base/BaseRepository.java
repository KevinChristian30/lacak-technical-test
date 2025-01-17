package com.kevinchristian.app.repository.base;

import com.kevinchristian.app.domain.entity.base.AbstractBaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends AbstractBaseEntity, ID> extends JpaRepository<T, ID> {
    Optional<T> findBySecureId(String secureId);
    void deleteBySecureId(String secureId);
}
