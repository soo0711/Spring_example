package com.example.lesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.lesson04.bo.UserBO;

@Controller
@RequestMapping("/lesson06/ex02")
public class Lesson06Ex02Controller {

	@Autowired
	private UserBO userBO;
	
	// 회원 가입 화면
	@GetMapping("/add-user-view")
	public String addUserView(){
		return "lesson06/ex02Adduser";
	}
	
	// 이름 중복 화면 - AJAX 요청
	@ResponseBody
	@GetMapping("/is-duplication-name")
	public Map<String, Object> isDuplicationName(
	         @RequestParam("name") String name){
	      
		  boolean isDuplication = userBO.isDuplicationByName(name);
			
	      Map<String, Object> result = new HashMap<>();
	      result.put("code", 200);//성공
	      result.put("is_duplication", isDuplication);//성공
	      
	      return result;
	   }
}
