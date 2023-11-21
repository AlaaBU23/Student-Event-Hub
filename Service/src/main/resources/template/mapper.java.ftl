package ${package.Mapper};

import ${package.Entity}.${entity};
import CS673.SpringBootStudentEventHub.domain.po.${entity}PO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("")
public interface ${table.mapperName} extends BaseMapper<${entity}PO>{


}