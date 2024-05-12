package academicPerformance;

import java.util.ArrayList;
import java.util.List;

public class School {

	private String name;
	private List<Teacher> teachers;
	private List<Student> students;

	public School(String name) {
		this.name = name;
		this.teachers = new ArrayList<>();
		this.students = new ArrayList<>();
	}

	public void addTeacher(Teacher teacher) {
		teachers.add(teacher);
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void displayTeacherRatings() {
		System.out.println("Teacher Ratings:");
		for (Teacher teacher : teachers) {
			System.out.println("Teacher: " + teacher.name);
			System.out.println("Average Rating: " + teacher.calculateAverageRating());
		}
	}
}
