package StudentEventHub.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
//import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@Configuration
@EnableTransactionManagement
@MapperScan("SpringBootStudentEventHub.mapper")
public class MybatisPlusConfig {

    /**
     * Pagination plugin for pagehelper
     */
//    @Bean
//    public PageInterceptor pageInterceptor() {
//        return new PageInterceptor();
//    }

    /**
     * new paging plug-ins , a slow and two slow to follow the rules of mybatis ,
     * you need to set MybatisConfiguration#useDeprecatedExecutor = false to avoid caching problems .
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //   interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.ORACLE_12C));
        //Optimist Lock
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }


    /**
     * Setting Fill Defaults
     */
    @Bean
    public MetaObjectHandler autoFillMetaObjectHandler() {

        MetaObjectHandler autoFillMetaObjectHandler = new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {
                this.fillStrategy(metaObject, "createTime", new Date());
                this.fillStrategy(metaObject, "updateTime", new Date());
                this.fillStrategy(metaObject, "isDeleted", 0);

            }

            @Override
            public void updateFill(MetaObject metaObject) {
                this.fillStrategy(metaObject, "updateTime", new Date());
            }
        };
        return autoFillMetaObjectHandler;
    }
}
