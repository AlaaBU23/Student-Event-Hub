package StudentEventHub.config;

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
            log.info("Successful project launch！interface documentation address: http://" + hostAddress + ":" + port + "/doc.html");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("xxx", "", "xxx@xxx.com");
        return new ApiInfoBuilder()
                .title("xxx")
                .termsOfServiceUrl("xxx")
                .contact(contact) // Higher versions call this overloaded method
                .version("1.0")
                .build();
    }

    @Bean
    public Docket api() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        ticketPar.name("Authorization").description("user token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //The Authorization parameter in the header is not required and can be passed empty.
        pars.add(ticketPar.build());    //Each method name also tells you what parameters are being set by the current method.
        return new Docket(DocumentationType.SWAGGER_2)      // Select swagger2 version
                .apiInfo(apiInfo())
                .enableUrlTemplating(true)//Define api document summary information
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))    // The inclusion of annotations is used here to identify the interface to be displayed
                .apis(RequestHandlerSelectors.basePackage("StudentEventHub"))
                .paths(PathSelectors.any())     // Specify all paths
                .build()
                .ignoredParameterTypes(HttpSession.class, HttpServletRequest.class, HttpServletResponse.class)
                .globalOperationParameters(pars);

    }

}
