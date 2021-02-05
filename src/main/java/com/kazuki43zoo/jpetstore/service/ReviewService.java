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
package com.kazuki43zoo.jpetstore.service;

import com.kazuki43zoo.jpetstore.component.exception.ResourceNotFoundException;
import com.kazuki43zoo.jpetstore.domain.Review;
import com.kazuki43zoo.jpetstore.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author Kazuki Shimizu
 */
@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewMapper reviewMapper;

	public Review getReview(String productId) {
		return Optional.ofNullable(reviewMapper.getReview(productId))
				.orElseThrow(() -> new ResourceNotFoundException("" + "Review", productId));
	}

	public void create(Review review) {
//		long time = new Date().getTime();
//		String timeStr = String.valueOf(time).substring(2, 10);
//		review.setProductId(timeStr);
		reviewMapper.createReview(review);
	}
}