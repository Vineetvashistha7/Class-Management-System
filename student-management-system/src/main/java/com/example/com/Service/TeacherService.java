package com.example.com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.com.Entity.Student;
import com.example.com.Entity.Teacher;
import com.example.com.Repository.TeacherRepo;

@Service
public class TeacherService {
	
	
	@Autowired
	 public TeacherRepo teacherRepo;

	public List<Teacher> getAllStudents() {
		// TODO Auto-generated method stub
		return teacherRepo.findByStatus(1);
	}

	public void saveTeacher(Teacher teacher) {
		teacher.setStatus(1);;
		teacherRepo.save(teacher);	
	}
	
	public Teacher getTeacherById(int id) {
		return teacherRepo.findById(id).get();
	}

	
	public Teacher updateTeacher(Teacher teacher) {
		teacher.setStatus(1);
		return teacherRepo.save(teacher);
	}

	
	public void deleteTeacherById(int id) {
		Teacher s=teacherRepo.findById(id).get();	
		s.setStatus(0);
		teacherRepo.save(s);
		
	}

}
