package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // 리스트에 있는 것을 override 안해도 주소말고 값이 나온다. (객체 출력 시 필드 값이 보여진다.)
@AllArgsConstructor // 파라미터가 모두 있는 생성자
@NoArgsConstructor // 파리미터가 없는 생성자 만들기
@Getter
@Table(name = "new_student")
@Builder // setter 대신에 사용
@Entity // '이 객체는 Entity다'라고 JPA에게 알려주는 annotation (JPA - DB)
public class StudentEntity { // student_entity를 찾으려 하기 때문에 이건 table명이 아니라고 알려주기에 Table annotation을 붙인다.
	
	@Id // primary key라고 알려준다.
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 유일한 pk이다.
	private int id;
	
	private String name;
	
	@Column(name="phoneNumber") // CamelCase라고 명시
	private String phoneNumber;
	
	private String email;
	
	@Column(name="dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp // createdAt이 null이어도 현재시간으로 저장
	@Column(name="createdAt", updatable = false) // updatable는 update시 변경되지 않도록 설정, 한번 들어가면 끝
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp // createdAt이 null이어도 현재시간으로 저장
	@Column(name="updatedAt")
	private ZonedDateTime updatedAt;
	
}
