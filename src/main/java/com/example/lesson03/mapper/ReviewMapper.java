package com.example.lesson03.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson03.domain.Review;

@Repository
public interface ReviewMapper {
	
	// input: id        
	// output:Review
	public Review selectReview(int id);
	
	// input: Review
	// output: 성공한 행의 개수(int)
	// mybatis가 int를 알아서 채워준다. (성공한 행의 개수를)
	public int insertReview(Review review);
	
	public int insertReviewAsField(
			// 하나의 map 된 것 => @Param
			@Param("storeId")int storeId, 
			@Param("menu")String menu, 
			@Param("userName")String userName, 
			@Param("point")Double point,
			@Param("review")String review);
	
	// input: id, review
	// output: 성공한 행의 개수(int)
	public int updateReviewById(
			@Param("id") int id,
			@Param("review") String review);

	// input: id
	// output: 성공한 행의 개수 (안 줘도 상관 없음)
	public int deleteReviewById(int id);
}
