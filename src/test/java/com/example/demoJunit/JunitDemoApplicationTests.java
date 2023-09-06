package com.example.demoJunit;

import com.example.demoJunit.model.Course;
import com.example.demoJunit.model.Enrollment;
import com.example.demoJunit.model.Student;
import com.example.demoJunit.repository.CourseRepository;
import com.example.demoJunit.repository.EnrollmentRepository;
import com.example.demoJunit.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class JunitDemoApplicationTests {
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EnrollmentRepository enrollmentRepository;

	@Test
	public void testCourseStudentEnrollmentRelationship() {
		// Create a course
		Course course = new Course("Sport", "Miscare");
		courseRepository.save(course);

		// Create a student
		Student student = new Student("Victor", "victor@yahoo.com");
		studentRepository.save(student);

		// Create an enrollment
		Enrollment enrollment = new Enrollment(course, student);
		enrollmentRepository.save(enrollment);

		// Retrieve the saved entities
		Course retrievedCourse = courseRepository.findById(course.getId()).orElse(null);
		Student retrievedStudent = studentRepository.findById(student.getId()).orElse(null);
		Enrollment retrievedEnrollment = enrollmentRepository.findById(enrollment.getId()).orElse(null);

		// Check relationships
		assertNotNull(retrievedCourse);
		assertNotNull(retrievedStudent);
		assertNotNull(retrievedEnrollment);

		// Check the relationship between Course and Enrollment
		assertEquals(1, retrievedCourse.getEnrollments().size());
		assertEquals(enrollment, retrievedCourse.getEnrollments().iterator().next());

		// Check the relationship between Student and Enrollment
		assertEquals(1, retrievedStudent.getEnrollments().size());
		assertEquals(enrollment, retrievedStudent.getEnrollments().iterator().next());

		// Check that the enrollment references the correct course and student
		assertEquals(course, retrievedEnrollment.getCourse());
		assertEquals(student, retrievedEnrollment.getStudent());
	}
}
