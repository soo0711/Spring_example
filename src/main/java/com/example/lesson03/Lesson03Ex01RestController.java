package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.domain.Review;

@RestController // spring bean
public class Lesson03Ex01RestController {
 
	@Autowired
	private ReviewBO reviewBO;
	
	// url: http://localhost:8008/lesson03/ex01
	// url: http://localhost:8008/lesson03/ex01?id=7
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			// @RequestParam(value = "id") int id // 필수 파라미터
			// @RequestParam(value = "id", required = true) int id // 필수 파라미터
			// @RequestParam(value = "id", required = false) Integer id // 비필수 파라미터, id = null로 들어간다.
			// @RequestParam(value = "id", defaultValue = "1") int id // 비필수 + default = 1 숫자여도 무조건 "" 해야한다.
			@RequestParam("id") int id) { // 필수 파라미터, 뒤에 추가할게 없으면 value 안 써도 된다.
//		if (id == null) {
//			id = 1;
//		}
		return reviewBO.getReview(id); // response body JSON
	}
	
}
