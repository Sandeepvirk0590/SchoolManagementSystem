package academicPerformance;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
	private String employeeID;
	private double salary;
	private List<String> coursesTaught;
	private List<Integer> ratings;

	public Teacher(String name, int age, String gender, String employeeID, double salary, List<String> coursesTaught) {
		super(name, age, gender);
		this.employeeID = employeeID;
		this.salary = salary;
		this.coursesTaught = coursesTaught;
		this.ratings = new ArrayList<>();
	}

	@Override
	public String describeRole() {
		return "Teacher";
	}

	public void addRating(int rating) {
		ratings.add(rating);
	}

	public double calculateAverageRating() {
		if (ratings.isEmpty())
			return 0;
		double sum = 0;
		for (int rating : ratings) {
			sum += rating;
		}
		return sum / ratings.size();
	}

}