package CS673.SpringBootStudentEventHub.service;

import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.HostsPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.Hosts;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.HostsMapper;

/**
 * <p>
 * $!{table.comment} service class
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
public interface IHostsService extends IService<HostsPO> {
    public HostsRespVO getHosts(String id);

    public Integer deleteHosts(String id);

    public HostsRespVO addHosts(HostsAddReqVO HostsAddVO);

    public HostsRespVO updateHosts(HostsUpdateReqVO Hosts_UpdateReqVO);

    public Integer deleteHostsList(HostsBatchReqVO Hosts_BatchReqVO);

}