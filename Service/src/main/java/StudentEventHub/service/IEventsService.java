package StudentEventHub.service;

import StudentEventHub.domain.vo.EventsAddReqVO;
import StudentEventHub.domain.vo.EventsBatchReqVO;
import StudentEventHub.domain.vo.EventsRespVO;
import StudentEventHub.domain.vo.EventsUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

import StudentEventHub.domain.po.EventsPO;
import StudentEventHub.domain.vo.*;

import java.util.List;

/**
 * <p>
 * $!{table.comment} service class
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
public interface IEventsService extends IService<EventsPO> {
    public EventsRespVO getEvents(String id);

    public Integer deleteEvents(String id);

    public EventsRespVO addEvents(EventsAddReqVO EventsAddVO);

    public EventsRespVO updateEvents(EventsUpdateReqVO Events_UpdateReqVO);

    public Integer deleteEventsList(EventsBatchReqVO Events_BatchReqVO);

    public List<EventsRespVO> getEventListByZipcode(String zipCode);

}