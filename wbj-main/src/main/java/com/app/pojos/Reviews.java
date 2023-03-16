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
@Table(name = "reviews")
public class Reviews extends BaseEntity{
	public Reviews() {
		
	}

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    
	    @JoinColumn(name = "user_id", nullable = false)
	    private Long user_id;

	    
	    @JoinColumn(name = "mechanic_id", nullable = false)
	    private Long mechanic_id;

	    
	    @JoinColumn(name = "service_id", nullable = false)
	    private Long service_id;

	    @Column(name = "rating", nullable = false)
	    private Integer rating;

	    @Column(name = "comment", columnDefinition = "TEXT")
	    private String comment;

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

		public Long getMechanic_id() {
			return mechanic_id;
		}

		public void setMechanic_id(Long mechanic_id) {
			this.mechanic_id = mechanic_id;
		}

		public Long getService_id() {
			return service_id;
		}

		public void setService_id(Long service_id) {
			this.service_id = service_id;
		}

		public Integer getRating() {
			return rating;
		}

		public void setRating(Integer rating) {
			this.rating = rating;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		@Override
		public String toString() {
			return "Reviews [id=" + id + ", user_id=" + user_id + ", mechanic_id=" + mechanic_id + ", service_id="
					+ service_id + ", rating=" + rating + ", comment=" + comment + ", createdAt=" + createdAt + "]";
		}

		public Reviews(Long id, Long user_id, Long mechanic_id, Long service_id, Integer rating,
				String comment, Date createdAt) {
			
			this.id = id;
			this.user_id = user_id;
			this.mechanic_id = mechanic_id;
			this.service_id = service_id;
			this.rating = rating;
			this.comment = comment;
			this.createdAt = createdAt;
		}

		
	}

