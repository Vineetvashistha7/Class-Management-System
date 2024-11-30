package com.example.com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.com.Entity.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer>{
    
	
	@Query(value = "SELECT * FROM sms.teachers WHERE status = ?", nativeQuery = true)
	List<Teacher> findByStatus(int i);

}
