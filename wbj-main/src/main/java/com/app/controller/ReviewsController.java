package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.pojos.Reviews;
import com.app.service.ReviewsService;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReviewsController {
	@Autowired
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
