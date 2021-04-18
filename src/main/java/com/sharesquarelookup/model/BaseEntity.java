package com.sharesquarelookup.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by jt on 7/18/18.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public boolean isNew() {
        return this.id == null;
    }

    @CreationTimestamp
    @Column(name = "created", updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date created = new Date();

    @UpdateTimestamp
    @Column(name = "updated", updatable = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date updated = new Date();
}
