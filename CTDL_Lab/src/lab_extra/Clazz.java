package lab_extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Clazz {
    private String name;
    private String year;// 2017, 2018, 2019, ...
    private ArrayList<Student> students = new ArrayList<Student>();
//	private ByGPA based;

    public Clazz(String name, String year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    // sort students according to the given comparator c
    public void sortStudents(Comparator<Student> c) {
        students.sort(c);
    }

    // get top n students with highest GPA
    public ArrayList<Student> getTopNStudents(int n) {
        // TODO
        sortStudents(new ByGPA());
        ArrayList<Student> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(students.get(i));
        }
        return result;
    }

    // get random n students from the list of students
    public ArrayList<Student> getRandomNStudents(int n) {
        // TODO
        ArrayList<Student> result = new ArrayList<>();
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            int r = rd.nextInt(students.size());
            result.add(students.get(r));
        }

        return result;
    }

    // remove a student with a given id
    public boolean removeStudent(String id) {
        // TODO
		for (int i=0;i<students.size();i++){
			if(students.get(i).isSameID(id)) students.remove(students.get(i));
			return true;
		}
		return false;
    }

    // get all students who were born in a given birth year.
    public ArrayList<Student> getStudentByBirthYear(int birthYear) {
        // TODO
		ArrayList<Student> result= new ArrayList<>();
        for (int i=0;i<students.size();i++){
            if(students.get(i).iBorn(birthYear))
                result.add(students.get(i));
        }
        return result;
    }

    // similar as toString method, this method prints the name, year, and all
    // students of the class. Note that, using iterator
    public void display() {
        for (int i=0;i<students.size();i++){
            System.out.println(students.get(i).toString()+" ");
        }
        System.out.println();
    }

    public static void print(ArrayList<Student> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i).toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Clazz test = new Clazz("DH22DTA", "2022");
        ArrayList<Student> lop = new ArrayList<>();
        lop.add(new Student("123", "Loan", "Nguyen", 2004, 3.79));
        lop.add(new Student("123", "Loan", "Nguyen", 2004, 3.89));
        lop.add(new Student("123", "Loan", "Nguyen", 2004, 3.99));
        lop.add(new Student("123", "Loan", "Nguyen", 2004, 3.86));
        lop.add(new Student("123", "Loan", "Nguyen", 2004, 3.88));
        test.setStudents(lop);
//        test.sortStudents(new ByGPA());
//		print(test.getRandomNStudents(3));
//        print(test.students);
        test.display();
    }
}
