package example.spring.rest.data.jpa.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import example.spring.rest.data.jpa.Service.CourseService;
import example.spring.rest.data.jpa.entity.Course;

@RestController
public class CourseController {
	@Autowired
	private CourseService  serviceObj;
	@GetMapping("/courses")
	public Collection<Course> getAllCourse(){
		Collection<Course> allCourse = serviceObj.getCourseAll();
		return allCourse;
	}
	@GetMapping("/courses/{crsId}")//crsId==>path variable
	public Course getSinglerCourse(@PathVariable("crsId") String courseId){
		Course foundCourse = serviceObj.getSingleCourse(courseId);
		return foundCourse;
	}
	
	@PostMapping("/courses")
	public void CreateNewCourse(@RequestBody Course courseObject) {
		//ResquestBody==>used to cature the data available in request object.
		serviceObj.CreateNewCourse(courseObject);
	}
	
	

}
