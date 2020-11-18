package Week05.spring.xml;


import Week05.spring.vo.Student;

public class StudentDaoImpl implements StudentDao {

    public void add(Student student) {
        System.out.println("student: " + student.getId() + " " + student.getName());
    }

}
