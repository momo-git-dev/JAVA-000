package week5.spring.xml;


import week5.spring.vo.Student;

public class StudentDaoImpl implements StudentDao {

    public void add(Student student) {
        System.out.println("student: " + student.getId() + " " + student.getName());
    }

}
