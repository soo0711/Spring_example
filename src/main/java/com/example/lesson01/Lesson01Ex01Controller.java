package com.example.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/lesson01/ex01") // 공통되는 path를 쓸 경우, Method 위에 붙은 path보다 먼저 읽힌다.
@Controller // Spring bean(객체)으로 등록, 이게 없으면 아무것도 안되고 등록 되지 않는다.
public class Lesson01Ex01Controller {
	
	// String을 브라우저에 출력
	// url: http://localhost:8008/lesson01/ex01/1
	@ResponseBody // 리턴되는 값을 Response Body에 넣어 보낸다. => HTML로 출력
	@RequestMapping("/1")
	public String ex01_1 () {
		return "<h2>예제1번</h2>문자열을 Response Body로 보내는 예제";
	}
	
	// Map 출력 => JSON String 출력
	// url: http://localhost:8008/lesson01/ex01/2
	@RequestMapping("/2") // ResponseBody 위치를 public 옆에 써도 되지만 비추
	public @ResponseBody Map<String, Object> ex01_2(){
		Map<String, Object> map = new HashMap<>();
		map.put("딸기", 4);
		map.put("사과", 32);
		map.put("바나나", 20);
		map.put("블루베리", 11);
		
		// map을 리턴하면 json으로 나타낸다.
		// web starter에 jackson 라이브러리가 포함 되어 있기 때문
		return map;
	}
}
