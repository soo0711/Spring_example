package com.example.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson01/quiz03")
public class Lesson01Quiz03Controller {

	@RequestMapping("/1")
	public String quiz03_1() {
		
		return "lesson01/quiz03";
	}
}
