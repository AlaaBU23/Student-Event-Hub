package CS673.SpringBootStudentEventHub.service;

import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.EventsPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.Events;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.EventsMapper;

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