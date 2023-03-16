package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicles extends BaseEntity {
	
	public Vehicles() {
		
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    @JoinColumn(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "license_plate", nullable = false)
    private String licensePlate;

    @Temporal(TemporalType.TIMESTAMP)
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Date createdAt;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Vehicles [id=" + id + ", user_id=" + user_id + ", make=" + make + ", model=" + model + ", year=" + year
				+ ", color=" + color + ", licensePlate=" + licensePlate + ", createdAt=" + createdAt + "]";
	}

	public Vehicles(Long id, Long user_id, String make, String model, int year, String color,
			String licensePlate, Date createdAt) {
		
		this.id = id;
		this.user_id = user_id;
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.licensePlate = licensePlate;
		this.createdAt = createdAt;
	}

}


