package com.app.controller;

import com.app.pojos.Reviews;
import com.app.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class ReviewsController {
    private ReviewsService review;

    @PostMapping("/add")
    public Reviews addReviewsDetails(@RequestBody Reviews rev) {
        return review.addReviewsDetails(rev);
    }

    @GetMapping("/getbyid/{id}")
    public Reviews findBYId(@PathVariable Long id) {
        return review.findByIdd(id);
    }

    @DeleteMapping("/deletebyId/{id}")
    public String deleteReviewsDetails(@PathVariable Long id) {
        return review.deleteReviewsDetails(id);
    }

    @PutMapping("/update")
    public Reviews updateReviewsDetails(@RequestBody Reviews rev) {
        return review.updateReviewsDetails(rev);
    }

}
