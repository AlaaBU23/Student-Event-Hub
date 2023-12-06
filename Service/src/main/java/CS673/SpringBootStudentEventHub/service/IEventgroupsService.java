package CS673.SpringBootStudentEventHub.service;

import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.EventgroupsPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.Eventgroups;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.EventgroupsMapper;

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