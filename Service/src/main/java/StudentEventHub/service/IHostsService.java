package StudentEventHub.service;

import StudentEventHub.domain.vo.HostsAddReqVO;
import StudentEventHub.domain.vo.HostsBatchReqVO;
import StudentEventHub.domain.vo.HostsRespVO;
import StudentEventHub.domain.vo.HostsUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

import StudentEventHub.domain.po.HostsPO;
import StudentEventHub.domain.vo.*;

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