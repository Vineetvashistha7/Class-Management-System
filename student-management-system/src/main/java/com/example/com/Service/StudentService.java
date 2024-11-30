package com.example.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.com.Entity.Student;
import com.example.com.Repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepository;
	
	
	
	public List<Student> getAllStudents() {
		return studentRepository.findByStatus(1);
	}

	
	public Student saveStudent(Student student) {
		student.setStatus(1);
		return studentRepository.save(student);
	}

	
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	
	public Student updateStudent(Student student) {
		student.setStatus(1);
		return studentRepository.save(student);
	}

	
	public void deleteStudentById(int id) {
		Student s=studentRepository.findById(id).get();	
		s.setStatus(0);
		studentRepository.save(s);
		
	}
}
