package week5.spring.annotation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import week5.spring.vo.Student;
import week5.spring.xml.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public void add(Student student) {
        studentDao.add(student);
    }
}
