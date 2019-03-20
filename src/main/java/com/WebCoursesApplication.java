package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebCoursesApplication {

	public static void main(String[] args) {
		//for others lessons
		SpringApplication.run(WebCoursesApplication.class, args);
		//for Lesson9
//		ConfigurableApplicationContext context = SpringApplication.run(WebCoursesApplication.class, args);
//
//		CourseRepository courseRepository = context.getBean(CourseRepository.class);
//		GroupRepository groupRepository = context.getBean(GroupRepository.class);
//		StudentService studentService = context.getBean(StudentService.class);
//
//		Course course = courseRepository.save(new Course("Title", "DESC", new ArrayList<>()));
//		Group group = groupRepository.save(new Group("7M1301", new ArrayList<>()));
//
//		Student student = new Student("Alex", "Pupkin", group, null, new ArrayList<>());
//		PersonalCard personalCard = new PersonalCard(19, 7.6, Gender.MALE, student);
//
//		student.setPersonalCard(personalCard);
//		student.getCourses().add(course);
//
//		group.getStudents().add(student);
//
//		course.getStudents().add(student);
//
//		Student save = studentService.save(student);
//		System.out.println(save);
//		System.out.println(save.getGroup());
//		System.out.println(save.getPersonalCard());
//		save.getCourses().forEach(course1 -> System.out.println(course1));
	}
}
