package com.app.service;

import com.app.pojos.Reviews;
import com.app.repo.RepositoryReviews;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewsServiceImpl implements ReviewsService {

    public RepositoryReviews repo;


    @Override
    public Reviews addReviewsDetails(Reviews rev) {
        // TODO Auto-generated method stub
        return repo.save(rev);
    }


    @Override
    public Reviews findByIdd(Long id) {
        // TODO Auto-generated method stub

        return repo.findById(id).get();
    }


    @Override
    public String deleteReviewsDetails(Long id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
        return "DetailsDelete";
    }

    @Override
    public Reviews updateReviewsDetails(Reviews rev) {
        // TODO Auto-generated method stub
        return repo.save(rev);
    }
}
