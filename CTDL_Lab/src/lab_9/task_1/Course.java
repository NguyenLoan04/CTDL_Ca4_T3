package lab_9.task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private String id;
    private String title;
    private String type;
    private List<Student> students;
    private String lecturer;

    public Course(String id, String title, String type, String lecturer) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.students = new ArrayList<>();
        this.lecturer = lecturer;
    }
    public void add(Student s){
        this.students.add(s);
    }
    public boolean moreStudents(Course max) {
        return this.students.size()> max.students.size();
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getType() {
        return type;
    }

    public int higherStudentsThan(Course o1) {
        return students.size()- o1.students.size();
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", students=" + students.toString() +
                ", lecturer='" + lecturer + '\'' +
                '}';
    }

    public Map<Integer, List<Student>> groupStudentsByYear() {
        Map<Integer, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            if (result.containsKey(student.getYear())) {
                result.get(student.getYear()).add(student);
            }
            else {
                List<Student> list = new ArrayList<>();
                list.add(student);
                result.put(student.getYear(), list);
            }
        }
        return result;
    }

}
