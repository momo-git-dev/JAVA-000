package week5.spring;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week5.spring.annotation.StudentService;
import week5.spring.javaconfig.StudentBean;
import week5.spring.javaconfig.StudentConfig;
import week5.spring.vo.Student;
import week5.spring.xml.StudentDao;

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
