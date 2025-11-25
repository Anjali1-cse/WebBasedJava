package example.spring.rest.data.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import example.spring.rest.data.jpa.entity.Course;
// no need of @repository because JpaRepository is already a managed Component
// and CourseRepository is extended from it so it also becomes a managed Component
public interface CourseRepository extends JpaRepository<Course, String> {
     //Additional method if any
	// Nothing to be added if only regular CURD operations are to be Perform
}
