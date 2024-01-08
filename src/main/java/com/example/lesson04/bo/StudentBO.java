package com.example.lesson04.bo;

import java.time.ZonedDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.domain.Student;
import com.example.lesson04.mapper.StudentMapper;
import com.example.lesson07.entity.StudentEntity;
import com.example.lesson07.repository.StudentRepository;

@Service
public class StudentBO {

	// Mapper용
	@Autowired
	private StudentMapper studentMapper;
	
	// JPA용
	@Autowired
	private StudentRepository studentRepository;
	
	// JPA로 insert
	public StudentEntity addStudent(String name, String phoneNumber, 
									String email, String dreamJob) {
		
		StudentEntity student = StudentEntity.builder() // setter처럼 사용
								.name(name)
								.phoneNumber(phoneNumber)
								.email(email)
								.dreamJob(dreamJob)
								.createdAt(ZonedDateTime.now()) // @UpdateTimestamp가 있으면 생략 가능
								.build(); // 마지막 닫기 
		
		return studentRepository.save(student); // 이때는 id도 채워져서 온다.
	}
	
	// Mybatis로 insert
	// input: parameters
	// output: X
	public void addStudent(Student student) {
		studentMapper.insertStudent(student);
	}
	
	// input: id, dreamJob
	// JPA로 업데이트
	public StudentEntity updateStudentDreamJobById(int id, String dreamJob) {
		// select 
		StudentEntity student = studentRepository.findById(id).orElse(null);
		// .orElse로 가지고 왔는데 null이라면 null로 지정하겠다라고 지정한다.
		// 그러면 student는 null이거나 았다.
		
		// update - save
		if (student != null) {
			student = student.toBuilder() // 기존 필드값들은 유지하고 일부 필드만 변경 - toBuilder
							.dreamJob(dreamJob) 
							.build();	// ★ 반드시 다시 저장한다!! ★
			
			student = studentRepository.save(student);
		}
		
		return student; // student or null이 들어간다.
	}
	
	// JPA delete
	public void deleteStudentById(int id) {
		// select
		// 방법 1)
		/*
		StudentEntity student = studentRepository.findById(id).orElse(null);
		if (student != null) {
			studentRepository.delete(student);
		}
		*/
		
		// 방법 2)
		// delete
		// null 검사하는 객체
		Optional<StudentEntity> studentOptional = studentRepository.findById(id);
		studentOptional.ifPresent(s -> studentRepository.delete(s));
		
	}
	
	
	// input: id
	// output: X
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
}
