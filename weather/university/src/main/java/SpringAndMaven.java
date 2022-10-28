import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
class SpringAndMaven {


    private static StudentService studentService1;
    private static StudentService studentService2;

    @Autowired
    public SpringAndMaven(@Qualifier("abc") StudentService studentService1
            , @Qualifier("abc") StudentService studentService2) {
        SpringAndMaven.studentService1 = studentService1;
        SpringAndMaven.studentService2 = studentService2;
    }


    public SpringAndMaven(@Qualifier("abc") StudentService studentService1) {
        SpringAndMaven.studentService1 = studentService1;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAndMaven.class, args);
        System.out.println(studentService1 == studentService2);
    }
}

@Component
interface StudentService {}
@Component("abc") //bean
class StudentServiceImpl implements StudentService {
    @Override
    public String toString() {
        return "StudentServiceImpl{}";
    }
}