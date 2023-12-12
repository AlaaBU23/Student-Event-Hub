package StudentEventHub.service;

import StudentEventHub.domain.vo.AttendeesAddReqVO;
import StudentEventHub.domain.vo.AttendeesBatchReqVO;
import StudentEventHub.domain.vo.AttendeesRespVO;
import StudentEventHub.domain.vo.AttendeesUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

import StudentEventHub.domain.po.AttendeesPO;
import StudentEventHub.domain.vo.*;

/**
 * <p>
 * $!{table.comment} service class
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