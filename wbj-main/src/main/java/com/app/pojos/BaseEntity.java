package com.app.pojos;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@CrossOrigin(origins = "*", maxAge = 3600)
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    public BaseEntity(Long id) {
        super();
        this.id = id;
    }

    public BaseEntity() {

    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "BaseEntity [id=" + id + "]";
    }

}

