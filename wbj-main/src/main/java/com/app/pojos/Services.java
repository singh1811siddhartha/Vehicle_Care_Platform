package com.app.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity

@Table(name = "services")
public class Services extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "service_id")
    private Long id;
    @Column(name = "mechanic_id", nullable = false)
    private Long mechanic_id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Column(name = "duration", nullable = false)
    private String duration;
    @Column(name = "location", nullable = false)
    private String location;
    @Temporal(TemporalType.TIMESTAMP)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Date createdAt;

    public Services() {

    }


    public Services(Long id, Long mechanic_id, String name, String description, BigDecimal price,
                    String duration, String location, Date createdAt) {

        this.id = id;
        this.mechanic_id = mechanic_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.location = location;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMechanic_id() {
        return mechanic_id;
    }

    public void setMechanic_id(Long mechanic_id) {
        this.mechanic_id = mechanic_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Services [id=" + id + ", mechanic_id=" + mechanic_id + ", name=" + name + ", description=" + description
                + ", price=" + price + ", duration=" + duration + ", location=" + location + ", createdAt=" + createdAt
                + "]";
    }


}


