package StudentEventHub.service;

import StudentEventHub.domain.vo.GroupmembersAddReqVO;
import StudentEventHub.domain.vo.GroupmembersBatchReqVO;
import StudentEventHub.domain.vo.GroupmembersRespVO;
import StudentEventHub.domain.vo.GroupmembersUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

import StudentEventHub.domain.po.GroupmembersPO;
import StudentEventHub.domain.vo.*;

/**
 * <p>
 * $!{table.comment} service class
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
public interface IGroupmembersService extends IService<GroupmembersPO> {
    public GroupmembersRespVO getGroupmembers(String id);

    public Integer deleteGroupmembers(String id);

    public GroupmembersRespVO addGroupmembers(GroupmembersAddReqVO GroupmembersAddVO);

    public GroupmembersRespVO updateGroupmembers(GroupmembersUpdateReqVO Groupmembers_UpdateReqVO);

    public Integer deleteGroupmembersList(GroupmembersBatchReqVO Groupmembers_BatchReqVO);

}