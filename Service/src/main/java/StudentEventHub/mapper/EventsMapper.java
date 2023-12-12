package StudentEventHub.mapper;

import StudentEventHub.domain.po.EventsPO;
import StudentEventHub.domain.vo.*;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface EventsMapper extends BaseMapper<EventsPO> {


}