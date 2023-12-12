package StudentEventHub.mapper;

import StudentEventHub.domain.po.RatingsPO;
import StudentEventHub.domain.vo.*;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface RatingsMapper extends BaseMapper<RatingsPO> {


}