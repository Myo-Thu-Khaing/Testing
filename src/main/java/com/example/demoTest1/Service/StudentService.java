package com.example.demoTest1.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoTest1.Entity.Student;
import com.example.demoTest1.Repo.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo stuRepo;
	
	public void create(Student stu) {
		stuRepo.save(stu);
	}
	
	public List<Student> read(){
		List<Student> data=stuRepo.findAll();
		return data;	
	}
	
	public Student readOne(Long id){
		Student data=stuRepo.findById(id).get();
		return data;	
	}
	
	public void delete(Long id){
		stuRepo.deleteById(id);	
	}
	
	public Student update(long id,Student stu) {
		Student data=stuRepo.findById(id).get();
		data.setName(stu.getName());
		data.setAge(stu.getAge());
		return data;
	}
	
	
	

}
