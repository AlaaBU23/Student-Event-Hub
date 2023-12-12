package StudentEventHub.service;

import StudentEventHub.domain.vo.EventgroupsAddReqVO;
import StudentEventHub.domain.vo.EventgroupsBatchReqVO;
import StudentEventHub.domain.vo.EventgroupsRespVO;
import StudentEventHub.domain.vo.EventgroupsUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

import StudentEventHub.domain.po.EventgroupsPO;
import StudentEventHub.domain.vo.*;

/**
 * <p>
 * $!{table.comment} service class
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
public interface IEventgroupsService extends IService<EventgroupsPO> {
    public EventgroupsRespVO getEventgroups(String id);

    public Integer deleteEventgroups(String id);

    public EventgroupsRespVO addEventgroups(EventgroupsAddReqVO EventgroupsAddVO);

    public EventgroupsRespVO updateEventgroups(EventgroupsUpdateReqVO Eventgroups_UpdateReqVO);

    public Integer deleteEventgroupsList(EventgroupsBatchReqVO Eventgroups_BatchReqVO);

}