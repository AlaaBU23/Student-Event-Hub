package CS673.SpringBootStudentEventHub;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = {DynamicDataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "CS673.SpringBootStudentEventHub.mapper")
@EnableFeignClients(basePackages = "CS673.SpringBootStudentEventHub")
@EnableWebMvc
public class SpringBootStudentEventHubApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(new Class<?>[]{SpringBootStudentEventHubApplication.class});
        application.setAllowBeanDefinitionOverriding(true);
        application.run(args);
    }

}
