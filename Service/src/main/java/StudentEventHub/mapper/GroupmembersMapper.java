package StudentEventHub.mapper;

import StudentEventHub.domain.po.GroupmembersPO;
import StudentEventHub.domain.vo.*;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface GroupmembersMapper extends BaseMapper<GroupmembersPO> {


}