package com.example.demoTest1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demoTest1.Entity.Student;
import com.example.demoTest1.Service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService stuService;
	
	@PostMapping("/create")
	public ResponseEntity<Student> create(@RequestBody Student student){
		stuService.create(student);
		return new ResponseEntity<>(student,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<Student>> read(){
		List<Student> data=stuService.read();
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	@GetMapping("/read/{id}")
	public ResponseEntity<Student> readOne(@PathVariable long id){
		Student data=stuService.readOne(id);
		return new ResponseEntity<>(data,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Student> delete(@PathVariable long id){
		stuService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> update(@PathVariable long id,@RequestBody Student student){
		Student data =stuService.update(id,student);
		stuService.create(data);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	
	
	
	
	

}
