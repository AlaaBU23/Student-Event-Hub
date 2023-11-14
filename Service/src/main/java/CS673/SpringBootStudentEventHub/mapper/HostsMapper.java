package CS673.SpringBootStudentEventHub.mapper;

import CS673.SpringBootStudentEventHub.entity.Hosts;
import CS673.SpringBootStudentEventHub.domain.po.HostsPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@DS("")
public interface HostsMapper extends BaseMapper<HostsPO> {


}