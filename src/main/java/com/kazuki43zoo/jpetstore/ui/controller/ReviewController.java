/*
 *    Copyright 2016-2017 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.kazuki43zoo.jpetstore.ui.controller;

import com.kazuki43zoo.jpetstore.domain.Review;
import com.kazuki43zoo.jpetstore.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kazuki Shimizu
 */
@RequestMapping(value = "/review", method = {RequestMethod.GET, RequestMethod.POST})
@Controller
@RequiredArgsConstructor
public class ReviewController {
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

	private final ReviewService reviewService;

	@GetMapping("/review")
	public String viewReview(Model model) {
		Review review = reviewService.getReview("K9-BD-01");
		model.addAttribute(review);
		return "review/review";
	}

	@PostMapping
    public String create(Review review) {
		logger.warn(review.toString());
		review.setProductId("K9-BD-01");
		reviewService.create(review);
		return "review/review";
	}

}
