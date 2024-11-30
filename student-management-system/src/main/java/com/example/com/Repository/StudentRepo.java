package com.example.com.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.com.Entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	

	@Query(value = "SELECT * FROM sms.students WHERE status = ?", nativeQuery = true)
	List<Student> findByStatus(int i);

	

}
