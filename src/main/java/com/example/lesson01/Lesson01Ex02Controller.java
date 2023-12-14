package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//JSP로 보내는 컨트롤러
@Controller // @ResponseBody가 있으면 안된다!! (@RestController 여도 안된다.)
public class Lesson01Ex02Controller {

	// url: http://localhost/lesson01/ex02
	@RequestMapping("/lesson01/ex02") // Request path 주소
	public String ex02() {
		// (ResponseBody가 없을 때) return 되는 String은 jsp의 경로이다. 
		
		// /WEB-INF/jsp/와 .jsp가 자동으로 들어가게 해뒀다.
		return "lesson01/ex02"; // Response path 주소
	}
}
