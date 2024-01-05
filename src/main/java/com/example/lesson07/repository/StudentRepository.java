package com.example.lesson07.repository;

import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentRepository{

	@PersistenceContext
	private EntityManager em;
	
	public StudentEntity save(StudentEntity studentEntity) {
		em.persist(studentEntity);
		return studentEntity;
	}
	
}
