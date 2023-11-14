package CS673.SpringBootStudentEventHub.service;

import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.EventregistrationsPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.Eventregistrations;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.EventregistrationsMapper;

/**
 * <p>
 * $!{table.comment} 服务类
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
public interface IEventregistrationsService extends IService<EventregistrationsPO> {
    public EventregistrationsRespVO getEventregistrations(String id);

    public Integer deleteEventregistrations(String id);

    public EventregistrationsRespVO addEventregistrations(EventregistrationsAddReqVO EventregistrationsAddVO);

    public EventregistrationsRespVO updateEventregistrations(EventregistrationsUpdateReqVO Eventregistrations_UpdateReqVO);

    public Integer deleteEventregistrationsList(EventregistrationsBatchReqVO Eventregistrations_BatchReqVO);

}