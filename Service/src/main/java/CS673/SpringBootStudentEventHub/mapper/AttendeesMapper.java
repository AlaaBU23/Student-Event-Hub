package CS673.SpringBootStudentEventHub.mapper;

import CS673.SpringBootStudentEventHub.entity.Attendees;
import CS673.SpringBootStudentEventHub.domain.po.AttendeesPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface AttendeesMapper extends BaseMapper<AttendeesPO> {


}