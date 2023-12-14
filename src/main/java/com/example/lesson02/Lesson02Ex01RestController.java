package com.example.lesson02;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.domain.UsedGoods;

@RestController
public class Lesson02Ex01RestController {

	// url: http://localhost:8008/lesson02/ex01
	@RequestMapping("/lesson02/ex01")
	// 왜 Map으로 안하고 usedGoods를 만드냐?
	// : Map은 무엇이든 put 할 수 있고, 여러개를 만들 수 있기 때문에
	//   유지보수가 어렵고, 보안도 안된다.
	
	// DB와 연동 되는 UsedGoods을 
	// 바뀐 것들
	// DTO(Data Transfer Object): 필드, setter/getter
	// Domain: 테이블명(같은 개념)
	// Model: 테이블에 대한 내용
	
	// 바뀌지 않았음
	// Entity: DB에서 가져온 가공되지 않은 객체(온전한 값)
	// 라고 한다.
	
	public List<UsedGoods> ex01(){
		
		return ; // response => JSON
	}
}
