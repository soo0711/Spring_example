package com.example.lesson03.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson03.domain.Review;
import com.example.lesson03.mapper.ReviewMapper;

@Service
public class ReviewBO {

	@Autowired
	private ReviewMapper reviewMapper;
	
	// input: id
	// output: Review
	public Review getReview(int id) {
		
		return reviewMapper.selectReview(id);
	}
	
	// input: Review
	// output: 성공한 행의 개수(int)
	public int addReview(Review review) {
		return reviewMapper.insertReview(review);
	}
	
	public int addReviewAsField(int storeId, String menu, 
								String userName, Double point, // Double point는 null이 가능하기에 null로 써도 된다.
								String review) { // ↓ 순서가 맞는지 확인하기
		return reviewMapper.insertReviewAsField(storeId, menu, userName, point, review);
	}
	
	// input: id, review
	// output: 성공한 행의 개수(int)
	public int updateReviewById(int id, String review) {	
		return reviewMapper.updateReviewById(id, review);
	}
}
