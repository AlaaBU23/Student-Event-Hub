package CS673.SpringBootStudentEventHub.config;

import feign.Logger;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    /**
     * 配置FeignClient编译器，支持文件类型的传输
     *
     * @return
     */
    @Bean
    public SpringFormEncoder feignFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

    /**
     * 开启Feign日志输出
     *
     * @return
     */
    @Bean
    Logger.Level feignLevel() {
        return Logger.Level.FULL;
    }
}
