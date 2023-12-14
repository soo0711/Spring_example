package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson01/quiz03")
public class Lesson01Quiz03Controller {

	@RequestMapping("/1")
	public String quiz03_1() {
		// @ResponseBody가 아닌 단독으로 사용되는 @Controller + return String
		// => ViewResolver에 의해 리턴된 String의 jsp 경로를 찾고 화면이 구성된다.
		// => HTML 응답 (ResponseBody에 담겨짐)
		return "lesson01/quiz03";
	}
}
