package main.java;

public class Student {
	private String first_name;
	private String email;
	private String gender;
	
	// overloaded student constructor 
	public Student(String first_name, String email, String gender) {
		this.first_name = first_name;
		this.email = email;
		this.gender = gender;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
    public String toString() {
        return "Student{" +
                "first_name='" + first_name + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
	}
	
}
