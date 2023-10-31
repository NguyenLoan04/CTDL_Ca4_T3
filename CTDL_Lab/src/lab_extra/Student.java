package lab_extra;

import java.util.ArrayList;

public class Student {
	private String id;
	private String firstName;
	private String lastName;
	private int birthYear;
	private double GPA;

	public Student(String id, String firstName, String lastName, int birthYear, double GPA) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthYear = birthYear;
		this.GPA = GPA;
	}

	public int higherThan(Student o2) {
		double re= GPA- o2.GPA;
		if(re>0) return 1;
		if(re==0) return 0;
		return -1;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id='" + id + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthYear=" + birthYear +
				", GPA=" + GPA +
				'}';
	}

	public boolean isSameID(String idOther) {
		return id.equals(idOther);
	}

	public boolean iBorn(int oBirthYear) {
		return birthYear==oBirthYear;
	}
}
