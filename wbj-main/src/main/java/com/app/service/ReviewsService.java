package com.app.service;

import com.app.pojos.Reviews;

public interface ReviewsService {
	public Reviews addReviewsDetails(Reviews rev);
	public Reviews findByIdd(Long id);
	public String deleteReviewsDetails(Long id);
	public Reviews updateReviewsDetails(Reviews rev);
}
