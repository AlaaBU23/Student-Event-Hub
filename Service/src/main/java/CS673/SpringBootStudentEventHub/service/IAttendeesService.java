package CS673.SpringBootStudentEventHub.service;

import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.AttendeesPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.Attendees;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.AttendeesMapper;

/**
 * <p>
 * $!{table.comment} 服务类
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
public interface IAttendeesService extends IService<AttendeesPO> {
    public AttendeesRespVO getAttendees(String id);

    public Integer deleteAttendees(String id);

    public AttendeesRespVO addAttendees(AttendeesAddReqVO AttendeesAddVO);

    public AttendeesRespVO updateAttendees(AttendeesUpdateReqVO Attendees_UpdateReqVO);

    public Integer deleteAttendeesList(AttendeesBatchReqVO Attendees_BatchReqVO);

}