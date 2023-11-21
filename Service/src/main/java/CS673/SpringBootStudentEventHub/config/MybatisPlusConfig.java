package CS673.SpringBootStudentEventHub.config;

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
     * pagehelper的分页插件
     */
//    @Bean
//    public PageInterceptor pageInterceptor() {
//        return new PageInterceptor();
//    }

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //   interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.ORACLE_12C));
        //乐观锁
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }


    /**
     * 设置填充缺省值
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
