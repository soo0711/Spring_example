package com.example.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lesson04.bo.StudentBO;
import com.example.lesson04.domain.Student;

@Controller
@RequestMapping("/lesson04/ex02")
public class Lesson04Ex02Controller {

	@Autowired
	private StudentBO studentBO;
	
	// 학생 추가 화면
	// url: http://localhost:8008/lesson04/ex02/add-student-view
	@GetMapping("/add-student-view")
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	// 방금 가입된 학생 화면 & DB insert
	// url: http://localhost:8008/lesson04/ex02/add-student
	@PostMapping("/add-student")
	public String addStudent(				// @RequestParm을 더 많이 쓰긴 한다. (더 정확하기 때문에)
			@ModelAttribute Student student, // 태그의 name 속성 파라미터와 이름이 같은 필드에 매핑
			Model model) {
		
		// DB insert
		studentBO.addStudent(student);
		
		// DB에서 방금 가입된 사용자 select
		int id = student.getId();
	
		// selectStudentById => 완성
		Student latestStudent = studentBO.getStudentById(id);
		
		// Model 객체에 담는다.(jsp에서 사용하도록) 
		model.addAttribute("student", latestStudent);
		model.addAttribute("title", "방금 가입된 사용자 정보");
		
		// 화면 뿌리기 => table
		return "lesson04/afterAddStudent";
	}
}
