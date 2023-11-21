package CS673.SpringBootStudentEventHub.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import CS673.SpringBootStudentEventHub.domain.po.EventgroupsPO;
import CS673.SpringBootStudentEventHub.tools.*;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IEventgroupsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import CS673.SpringBootStudentEventHub.mapper.EventgroupsMapper;

/**
 * @author yilin
 * @date 2023-11-13
 */
@Service
@Slf4j
public class EventgroupsServiceImpl extends ServiceImpl<EventgroupsMapper, EventgroupsPO> implements IEventgroupsService {

    @Autowired
    private EventgroupsMapper Eventgroups_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1, 1, 1);

    @Override
    public EventgroupsRespVO getEventgroups(String id) {
        EventgroupsRespVO vo = new EventgroupsRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<EventgroupsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("group_id", id);
            vo = toVO(Eventgroups_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }


    public Integer deleteEventgroups(String id) {

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<EventgroupsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("group_id", id);
            deleteCount = Eventgroups_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
     * add Eventgroups
     *
     * @param EventgroupsAddVO
     * @return EventgroupsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public EventgroupsRespVO addEventgroups(EventgroupsAddReqVO EventgroupsAddVO) {
        EventgroupsRespVO vo = new EventgroupsRespVO();
        if (EventgroupsAddVO != null) {
            fillingAddParams(EventgroupsAddVO);
            EventgroupsPO po = fromReqVO(EventgroupsAddVO);
            Eventgroups_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
     * update Eventgroups
     *
     * @param Eventgroups_UpdateReqVO
     * @return EventgroupsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public EventgroupsRespVO updateEventgroups(EventgroupsUpdateReqVO Eventgroups_UpdateReqVO) {
        EventgroupsRespVO vo = new EventgroupsRespVO();
        if (Eventgroups_UpdateReqVO != null) {
            fillingUpdateParams(Eventgroups_UpdateReqVO);
            QueryWrapper<EventgroupsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("group_id", Eventgroups_UpdateReqVO.getGroupId());
            EventgroupsPO po = fromReqVO(Eventgroups_UpdateReqVO);
            Eventgroups_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
     * delete amount of Eventgroups
     *
     * @param Eventgroups_BatchReqVO
     * @return number of success deletes
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer deleteEventgroupsList(EventgroupsBatchReqVO Eventgroups_BatchReqVO) {
        Integer deleteCount = 0;
        if (Eventgroups_BatchReqVO != null) {
            List<String> ids = Eventgroups_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<EventgroupsPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("group_id", ids);
                deleteCount = Eventgroups_Mapper.delete(queryWrapper);
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
    private EventgroupsPO fromReqVO(EventgroupsAddReqVO queryVO) {
        EventgroupsPO po = new EventgroupsPO();
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
    private EventgroupsPO fromReqVO(EventgroupsUpdateReqVO queryVO) {
        EventgroupsPO po = new EventgroupsPO();
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
    private EventgroupsRespVO toVO(EventgroupsPO po) {
        EventgroupsRespVO vo = new EventgroupsRespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingAddParams(EventgroupsAddReqVO queryVO) {
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
    private void fillingUpdateParams(EventgroupsUpdateReqVO queryVO) {
        // TODO: 根据特性添加其它字段的定义
        if (StringUtils.isBlank(queryVO.getGroupId())) {
            queryVO.setGroupId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}