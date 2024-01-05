package com.example.lesson04.bo;

import java.time.ZonedDateTime;

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
	
	// input: id
	// output: X
	public Student getStudentById(int id) {
		return studentMapper.selectStudentById(id);
	}
	
}
