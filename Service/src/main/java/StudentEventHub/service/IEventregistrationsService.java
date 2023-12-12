package StudentEventHub.service;

import StudentEventHub.domain.vo.EventregistrationsAddReqVO;
import StudentEventHub.domain.vo.EventregistrationsBatchReqVO;
import StudentEventHub.domain.vo.EventregistrationsRespVO;
import StudentEventHub.domain.vo.EventregistrationsUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

import StudentEventHub.domain.po.EventregistrationsPO;
import StudentEventHub.domain.vo.*;

/**
 * <p>
 * $!{table.comment} service class
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