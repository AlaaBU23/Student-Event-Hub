package StudentEventHub;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication()
//@ComponentScan
@MapperScan("StudentEventHub.mapper")
//@EnableFeignClients(basePackages = "StudentEventHub")
@EnableWebMvc
public class SpringBootStudentEventHubApplication {

    public static void main(String[] args) {
//        SpringApplication application = new SpringApplication(new Class<?>[]{SpringBootStudentEventHubApplication.class});
//        application.setAllowBeanDefinitionOverriding(true);
//        application.run(args);
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootStudentEventHubApplication.class, args);
//        String[] beanDefinitionNames = run.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }

    }

}
