package StudentEventHub.mapper;

import StudentEventHub.domain.po.HostsPO;
import StudentEventHub.domain.vo.*;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface HostsMapper extends BaseMapper<HostsPO> {


}