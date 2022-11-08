package main.java;

public class Course {
	private String courseNo;
	private String grade;
	private double creditHour;
	
	//Overloaded Course constructor
	public Course(String courseNo, String grade, double creditHour) {
		this.courseNo = courseNo;
		this.grade = grade;
		this.creditHour = creditHour;
		
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getCreditHour() {
		return creditHour;
	}

	public void setCreditHour(double creditHour) {
		this.creditHour = creditHour;
	}
	
	@Override
    public String toString() {
        return "Course {" +
                "Course number='" + courseNo + '\'' +
                ", grade='" + grade + '\'' +
                ", Credit Hour='" + creditHour + '\'' +
                '}';
	}
}
