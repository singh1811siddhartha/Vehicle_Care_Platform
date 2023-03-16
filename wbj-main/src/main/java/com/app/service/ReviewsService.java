package com.app.service;

import com.app.pojos.Reviews;

public interface ReviewsService {
    Reviews addReviewsDetails(Reviews rev);

    Reviews findByIdd(Long id);

    String deleteReviewsDetails(Long id);

    Reviews updateReviewsDetails(Reviews rev);
}
