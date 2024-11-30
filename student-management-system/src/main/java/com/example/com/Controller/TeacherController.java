package com.example.com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//import com.example.com.Entity.Student;
import com.example.com.Entity.Teacher;
import com.example.com.Service.TeacherService;
//import com.example.com.Service.StudentService;

@Controller
public class TeacherController {

	@Autowired
	public TeacherService teacherService;

	
	
	// handler method to handle list students and return mode and view
	@GetMapping("/teachers")
	public String listTeacher(Model model) {
		model.addAttribute("teachers", teacherService.getAllStudents());
		return "home2";
	}
	
	
	
	
	@GetMapping("/teachers/new")
	public String createTeacherForm(Model model) {
		
		// create student object to hold student form data
		Teacher teacher =new Teacher();
		model.addAttribute("teacher", teacher);
		return "create_teacher";
		
	}
	
	@PostMapping("/teachers")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/edit/{id}")
	public String editTeacherForm(@PathVariable int id, Model model) {
		model.addAttribute("teacher", teacherService.getTeacherById(id));
		return "edit_teacher";
	}

	@PostMapping("/teachers/{id}")
	public String updateTeacher(@PathVariable int id,
			@ModelAttribute("teacher") Teacher teacher,
			Model model) {
		
		// get student from database by id
		Teacher existingStudent = teacherService.getTeacherById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(teacher.getFirstName());
		existingStudent.setLastName(teacher.getLastName());
		existingStudent.setLastName(teacher.getPhone());
		existingStudent.setLastName(teacher.getSubjects());
		existingStudent.setEmail(teacher.getEmail());
		
		// save updated student object
		teacherService.updateTeacher(existingStudent);
		return "redirect:/teachers";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/teachers/{id}")
	public String deleteTeacher(@PathVariable int id) {
		teacherService.deleteTeacherById(id);
		return "redirect:/teachers";
	}
	
}
