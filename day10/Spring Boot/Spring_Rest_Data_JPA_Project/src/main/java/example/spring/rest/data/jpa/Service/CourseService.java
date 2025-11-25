package example.spring.rest.data.jpa.Service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import example.spring.rest.data.jpa.entity.Course;
import example.spring.rest.data.jpa.repo.CourseRepository;

@Service// Marks this class as Service implementation class
public class CourseService {
    @Autowired// injecting CourseRepository into CourseService
	private CourseRepository repoObject;
	public Collection <Course> getCourseAll(){
		Collection<Course> allCourse = repoObject.findAll();
		return allCourse;
	}
	public Course getSingleCourse(String courseId) {
		Optional<Course> opRef = repoObject.findById(courseId);
		Course foundCourse = null;
		if(opRef.isPresent()) 
			foundCourse =opRef.get();
		return foundCourse;
		
	}
	public void CreateNewCourse(Course courseObject) {
		repoObject.save(courseObject);
	}

}
