package lab_extra;

import java.util.Comparator;

public class ByGPA implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.higherThan(o2);
    }
}
