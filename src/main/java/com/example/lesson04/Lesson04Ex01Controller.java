package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.lesson04.bo.UserBO;
import com.example.lesson04.domain.User;

@Controller // jsp를 내리는 경우 @ResponseBody 사용 안함
@RequestMapping("lesson04/ex01")
public class Lesson04Ex01Controller {
	
	@Autowired
	private UserBO userBO;
	
	// url: http:localhost:8008/lesson04/ex01/add-user-view
	@RequestMapping(path = "/add-user-view", method = RequestMethod.GET)
	public String addUserView() {
		return "lesson04/addUser"; // jsp view의 경로
	}
	
	
	// 회원가입 insert => 입력 성공 화면
	// url: http:localhost:8008/lesson04/ex01/add-user
	@PostMapping("/add-user") // 무조건 Post로 오는 것만 허용한다. -> 직접 치고 들어갈 수 없다.
	public String addUser(
			@RequestParam("name") String name,
			@RequestParam("yyyymmdd") String yyyymmdd,
			@RequestParam("email") String email,
			@RequestParam(value = "introduce", required = false) String introduce) {
		
		// DB insert
		userBO.addUser(name, yyyymmdd, email, introduce);
		
		return "lesson04/afterAddUser";
	}
	
	// 최근에 가입된 한명의 유저
	// url: http:localhost:8008/lesson04/ex01/latest-user-view
	@GetMapping("/latest-user-view")
	// Model: view 화면에 데이터를 넘겨주는 객체 (주머니라고 생각 view가 주머니에서 꺼낸다.)
	// ex) controller: 산타  model: 주머니  view: 선물 받는 어린아이
	public String LatestUserView(Model model) {
		// DB select (최신 가입자)
		User user = userBO.getLatestUser();
				
		// Model 주머니에 데이터를 담는다. => jsp에서 꺼내 쓴다.
		model.addAttribute("result", user);
		model.addAttribute("title", "최근 가입된 유저 정보");
		
		return "lesson04/latestUser"; // 결과 화면 jsp
	}
	
	
}
