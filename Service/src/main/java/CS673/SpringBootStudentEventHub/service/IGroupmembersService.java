package CS673.SpringBootStudentEventHub.service;

import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.GroupmembersPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.Groupmembers;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.GroupmembersMapper;

/**
 * <p>
 * $!{table.comment} 服务类
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