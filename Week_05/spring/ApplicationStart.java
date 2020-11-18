package Week05.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import Week05.spring.annotation.StudentService;
import Week05.spring.javaconfig.StudentBean;
import Week05.spring.javaconfig.StudentConfig;
import Week05.spring.vo.Student;
import Week05.spring.xml.StudentDao;

public class ApplicationStart {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = new Student();
        student.setId(66);
        student.setName("test66");
        // 使用xml配置方式
        StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDaoImpl");
        studentDao.add(student);

        // 使用注解方式
        StudentService studentService = (StudentService) applicationContext.getBean("studentServiceImpl");
        studentService.add(student);

        // java config方式
        applicationContext = new AnnotationConfigApplicationContext(StudentConfig.class);
        StudentBean studentBean = (StudentBean) applicationContext.getBean("studentBean");
        studentBean.init();

    }
}
