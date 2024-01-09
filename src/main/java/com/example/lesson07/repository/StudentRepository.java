package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.lesson07.entity.StudentEntity;

//@Transactional
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

//	@PersistenceContext
//	private EntityManager em;
//	
//	public StudentEntity save(StudentEntity studentEntity) {
//		em.persist(studentEntity);
//		return studentEntity;
//	}
	
	// Spring data JPA
	
	// 기본 제공 method
	// 엔티티 save(엔티티) -> 1. insert (id가 null), 2. update (id가 not null) 기능
	// Optional<엔티티> findById(id) -> 3. select 기능
	// void delete(엔티티) -> 4. delete 기능
	// List<엔티티객체> findAll();
	
	// 바뀌는 method
	// ex02/1 - JPQL 
	// 2)
	public List<StudentEntity> findAllByOrderByIdDesc();
	// 3)
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	// 4)
	public List<StudentEntity> findByName(String name);
	// 5)
	public List<StudentEntity> findByNameIn(List<String> names);
	// 6)
	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	// 7)
	public List<StudentEntity> findByEmailContaining(String email);
	// 8)
	public List<StudentEntity> findByNameStartingWith(String name);
	// 9)
	public List<StudentEntity> findByIdBetween(int startId, int endId);
	
	
	// ex02/2 - JPQL(Entity에 조회)
	// @Query(value = "select st from StudentEntity st where st.dreamJob =:dreamJob") // JPQL(엔티티 조회)
	// =:은 모두 다 붙여서 써야지 에러가 안 난다.
	@Query(value = "select * from new_student where dreamJob =:dreamJob", nativeQuery = true) // nativeQuery는 SQL문 조회
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
	
	
	
}
