package CS673.SpringBootStudentEventHub.mapper;

import CS673.SpringBootStudentEventHub.entity.Eventgroups;
import CS673.SpringBootStudentEventHub.domain.po.EventgroupsPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("")
public interface EventgroupsMapper extends BaseMapper<EventgroupsPO> {


}