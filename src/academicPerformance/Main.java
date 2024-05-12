package academicPerformance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Springfield High School Stream Allocation and Teacher Rating System!");

		School school = new School("Springfield High School");

		List<String> coursesTaughtByAlice = new ArrayList<>();
		coursesTaughtByAlice.add("Physics");
		coursesTaughtByAlice.add("Mathematics");
		Teacher alice = new Teacher("Alice Johnson", 35, "Female", "T1", 5000, coursesTaughtByAlice);
		school.addTeacher(alice);

		String studentName;
		boolean validName = false;
		do {
			System.out.println("Please enter the student's name:");
			studentName = sc.nextLine();
			validName = !studentName.matches(".*\\d.*");
			if (!validName) {
				System.out.println("Please enter a valid name without numbers!");
			}
		} while (!validName);

		int studentAge = 0;
		boolean validAge = false;
		do {
			System.out.println("Please enter the student's age:");
			if (sc.hasNextInt()) {
				studentAge = sc.nextInt();
				validAge = true;
			} else {
				System.out.println("Please enter a valid age!");
				sc.next();
			}
		} while (!validAge);

		sc.nextLine();

		String studentGender;
		boolean validGender = false;
		do {
			System.out.println("Please enter the student's gender (Male/Female):");
			studentGender = sc.nextLine();
			if (studentGender.equalsIgnoreCase("Male") || studentGender.equalsIgnoreCase("Female")) {
				validGender = true;
			} else {
				System.out.println("Please enter 'Male' or 'Female' only!");
			}
		} while (!validGender);

		double studentPercentage = 0;
		boolean validPercentage = false;
		do {
			System.out.println("Please enter the student's academic percentage:");
			if (sc.hasNextDouble()) {
				studentPercentage = sc.nextDouble();
				validPercentage = true;
			} else {
				System.out.println("Please enter a valid percentage!");
				sc.next();
			}
		} while (!validPercentage);

		Student student = new Student(studentName, studentAge, studentGender, "S001", studentPercentage);
		String stream = student.determineStream();
		System.out.println("Stream Allocation Result:");
		System.out.println("Name: " + student.name + ", Age: " + student.age + ", Gender: " + student.gender
				+ ", Academic Percentage: " + student.percentage + "%");
		System.out.println("Allocated Stream: " + stream);
		System.out.println(student.name + " can enroll in courses like " + stream + ".");

		System.out.println("Please enter the teacher's name you wish to rate:");
		String teacherName = sc.next();
		System.out.println("Please enter your rating for " + teacherName + " (1-5):");
		int rating = sc.nextInt();

		for (Teacher teacher : school.getTeachers()) {
			if (teacher.name.equalsIgnoreCase(teacherName)) {
				student.rateTeacher(teacher, rating);
				break;
			}
		}

		school.displayTeacherRatings();

		sc.close();
	}

}
