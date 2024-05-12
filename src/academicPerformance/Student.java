package academicPerformance;

public class Student extends Person {

	private String studentId;
	double percentage;

	public Student(String name, int age, String gender, String studentId, double percentage) {
		super(name, age, gender);
		this.studentId = studentId;
		this.percentage = percentage;
	}

	@Override
	public String describeRole() {
		return "Student";

	}

	public String determineStream() {
		if (percentage >= 85) {
			return "Non-Medical";
		} else if (percentage >= 75) {
			return "Medical";
		} else if (percentage >= 65) {
			return "Commerce";
		}
		return "Arts";
	}
	
	public void rateTeacher(Teacher teacher, int rating) {
        teacher.addRating(rating);
	}

}
