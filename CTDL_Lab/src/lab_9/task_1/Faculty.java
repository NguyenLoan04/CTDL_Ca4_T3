package lab_9.task_1;

import java.util.*;

public class Faculty {
    private String name;
    private String address;
    List<Course> courses;

    public Faculty(String name, String address) {
        this.name = name;
        this.address = address;
        this.courses= new ArrayList<>();
    }
    public void add(Course c){
        this.courses.add(c);
    }
    public Course getMaxPracticalCourse(){
        Course max= courses.get(0);
       for (int i=0;i<courses.size();i++){
           if(courses.get(i).moreStudents(max))
               max= courses.get(i);
       }
        return max;
    }
    public Map<Integer,List<Student>> groupStudentsByYear(){
        Map<Integer,List<Student>> map= new HashMap<>();
        for (Course c: courses){
            Set<Map.Entry<Integer, List<Student>>> set = c.groupStudentsByYear().entrySet();
            for (Map.Entry<Integer, List<Student>> e : set) {
                if (map.containsKey(e.getKey())) {
                    map.get(e.getKey()).addAll(e.getValue());
                } else {
                    map.put(e.getKey(), e.getValue());
                }
            }
        }
        return map;
    }
    public Set<Course> filterCourses(String type){
        Set<Course> set= new TreeSet<>(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o2.higherStudentsThan(o1);
            }
        });
        for (int i=0;i<courses.size();i++){
            if(courses.get(i).getType().equals(type)){
                set.add(courses.get(i));
            }
        }
        return set;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", courses=" + courses.toString() +
                '}';
    }

    public static void main(String[] args) {
        Faculty test= new Faculty("CNTT","DH Nong Lam");
        Course c1= new Course("DH22DTA","abc","type","DMT");
        c1.add(new Student("22130148","NBL",2022));
        c1.add(new Student("22130274","NTT",2022));
        Course c2= new Course("DH22DTB","def","type1","DMT");
        c2.add(new Student("22130148","NBL",2022));
        c2.add(new Student("22130274","NTT",2022));
        c2.add(new Student("21130171","DMT",2021));
        Course c3= new Course("DH22DTC","dfg","type2","DMT");
        c3.add(new Student("22130148","NBL",2022));
        c3.add(new Student("22130274","NTT",2022));
        c3.add(new Student("22130308","VTCT",2022));
        Course c4= new Course("DH22DH","ltc","type3","DMT");
        c4.add(new Student("22130148","NBL",2022));
        c4.add(new Student("22130274","NTT",2022));
        c4.add(new Student("22130308","VTCT",2022));
        c4.add(new Student("21130171","MT",2021));
        test.add(c1);
        test.add(c2);
        test.add(c3);
        test.add(c4);
//        System.out.println(test);
//        System.out.println(test.getMaxPracticalCourse());
//        System.out.println(test.groupStudentsByYear());
        System.out.println(test.filterCourses("type1"));

    }
}
