package CS673.SpringBootStudentEventHub.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import CS673.SpringBootStudentEventHub.domain.po.GroupmembersPO;
import CS673.SpringBootStudentEventHub.tools.*;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IGroupmembersService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import CS673.SpringBootStudentEventHub.mapper.GroupmembersMapper;

/**
 * @author yilin
 * @date 2023-11-13
 */
@Service
@Slf4j
public class GroupmembersServiceImpl extends ServiceImpl<GroupmembersMapper, GroupmembersPO> implements IGroupmembersService {

    @Autowired
    private GroupmembersMapper Groupmembers_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1, 1, 1);

    @Override
    public GroupmembersRespVO getGroupmembers(String id) {
        GroupmembersRespVO vo = new GroupmembersRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<GroupmembersPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("group_id", id);
            vo = toVO(Groupmembers_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }


    public Integer deleteGroupmembers(String id) {

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<GroupmembersPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("group_id", id);
            deleteCount = Groupmembers_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
     * add Groupmembers
     *
     * @param GroupmembersAddVO
     * @return GroupmembersRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public GroupmembersRespVO addGroupmembers(GroupmembersAddReqVO GroupmembersAddVO) {
        GroupmembersRespVO vo = new GroupmembersRespVO();
        if (GroupmembersAddVO != null) {
            fillingAddParams(GroupmembersAddVO);
            GroupmembersPO po = fromReqVO(GroupmembersAddVO);
            Groupmembers_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
     * update Groupmembers
     *
     * @param Groupmembers_UpdateReqVO
     * @return GroupmembersRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public GroupmembersRespVO updateGroupmembers(GroupmembersUpdateReqVO Groupmembers_UpdateReqVO) {
        GroupmembersRespVO vo = new GroupmembersRespVO();
        if (Groupmembers_UpdateReqVO != null) {
            fillingUpdateParams(Groupmembers_UpdateReqVO);
            QueryWrapper<GroupmembersPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("group_id", Groupmembers_UpdateReqVO.getGroupId());
            GroupmembersPO po = fromReqVO(Groupmembers_UpdateReqVO);
            Groupmembers_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
     * delete amount of Groupmembers
     *
     * @param Groupmembers_BatchReqVO
     * @return number of success deletes
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer deleteGroupmembersList(GroupmembersBatchReqVO Groupmembers_BatchReqVO) {
        Integer deleteCount = 0;
        if (Groupmembers_BatchReqVO != null) {
            List<String> ids = Groupmembers_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<GroupmembersPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("group_id", ids);
                deleteCount = Groupmembers_Mapper.delete(queryWrapper);
            }
        }
        return deleteCount;
    }

    /**
     * addReqVO转po
     *
     * @param queryVO
     * @return po
     */
    private GroupmembersPO fromReqVO(GroupmembersAddReqVO queryVO) {
        GroupmembersPO po = new GroupmembersPO();
        if (queryVO != null) {
            BeanUtils.copyProperties(queryVO, po);
        }
        return po;
    }

    /**
     * updateReq转po
     *
     * @param queryVO
     * @return po
     */
    private GroupmembersPO fromReqVO(GroupmembersUpdateReqVO queryVO) {
        GroupmembersPO po = new GroupmembersPO();
        if (queryVO != null) {
            BeanUtils.copyProperties(queryVO, po);
        }
        return po;
    }


    /**
     * po转vo
     *
     * @param po
     * @return vo
     */
    private GroupmembersRespVO toVO(GroupmembersPO po) {
        GroupmembersRespVO vo = new GroupmembersRespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingAddParams(GroupmembersAddReqVO queryVO) {
        // TODO: 根据特性添加其它字段的定义
        if (StringUtils.isBlank(queryVO.getGroupId())) {
            queryVO.setGroupId(String.valueOf(snowFlakeHelper.genId()));
        }
        // TODO: other field operations
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingUpdateParams(GroupmembersUpdateReqVO queryVO) {
        // TODO: 根据特性添加其它字段的定义
        if (StringUtils.isBlank(queryVO.getGroupId())) {
            queryVO.setGroupId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}