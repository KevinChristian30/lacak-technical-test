package com.kevinchristian.app.entity.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class AbstractBatchableBaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 3404209975721702645L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "secure_id", unique = true, length = 36)
    private String secureId;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "deleted_date")
    private Date deletedDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted = false;

    @Version
    @Column(name = "version")
    private Integer version = 0;

    @PrePersist
    private void generateSecureId() {
        secureId = UUID.randomUUID().toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (getClass() != object.getClass()) return false;
        if (Hibernate.getClass(this) != Hibernate.getClass(object)) return false;

        AbstractBatchableBaseEntity that = (AbstractBatchableBaseEntity) object;
        return null != id && Objects.equals(id, that.id) && Objects.equals(secureId, that.secureId);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
