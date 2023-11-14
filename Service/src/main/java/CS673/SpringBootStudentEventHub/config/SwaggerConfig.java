package CS673.SpringBootStudentEventHub.config;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置类
 */
@Log4j2
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        try {
            String hostAddress = Inet4Address.getLocalHost().getHostAddress();
            int port = event.getWebServer().getPort();
            log.info("项目启动成功！接口文档地址: http://" + hostAddress + ":" + port + "/doc.html");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("xxx", "", "xxx@xxx.com");
        return new ApiInfoBuilder()
                .title("xxx")
                .termsOfServiceUrl("xxx")
                .contact(contact) // 高版本调用此重载方法
                .version("1.0")
                .build();
    }

    @Bean
    public Docket api() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("Authorization").description("user token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的Authorization参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        return new Docket(DocumentationType.SWAGGER_2)      // 选择swagger2版本
                .apiInfo(apiInfo())
                .enableUrlTemplating(true)//定义api文档汇总信息
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))    // 这里采用包含注解的方式来确定要显示的接口
                .apis(RequestHandlerSelectors.basePackage("CS673.SpringBootStudentEventHub"))
                .paths(PathSelectors.any())     // 指定所有路径
                .build()
                .ignoredParameterTypes(HttpSession.class, HttpServletRequest.class, HttpServletResponse.class)
                .globalOperationParameters(pars);

    }

}
