package CS673.SpringBootStudentEventHub.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import CS673.SpringBootStudentEventHub.domain.po.EventsPO;
import CS673.SpringBootStudentEventHub.tools.*;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IEventsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import CS673.SpringBootStudentEventHub.mapper.EventsMapper;

/**
 * @author yilin
 * @date 2023-11-13
 */
@Service
@Slf4j
public class EventsServiceImpl extends ServiceImpl<EventsMapper, EventsPO> implements IEventsService {

    @Autowired
    private EventsMapper Events_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1, 1, 1);

    @Override
    public EventsRespVO getEvents(String id) {
        EventsRespVO vo = new EventsRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<EventsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("event_id", id);
            vo = toVO(Events_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }

    @Override
    public List<EventsRespVO> getEventListByZipcode(String zipCode) {
        List<EventsRespVO> vo = new ArrayList<>();
        if(StringUtils.isNotBlank(zipCode)) {
            QueryWrapper<EventsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("zip_code", zipCode);
            vo = toVOList(Events_Mapper.selectList(queryWrapper));
        }
        return vo;
    }


    public Integer deleteEvents(String id) {

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<EventsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("event_id", id);
            deleteCount = Events_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
     * add Events
     *
     * @param EventsAddVO
     * @return EventsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public EventsRespVO addEvents(EventsAddReqVO EventsAddVO) {
        EventsRespVO vo = new EventsRespVO();
        if (EventsAddVO != null) {
            fillingAddParams(EventsAddVO);
            EventsPO po = fromReqVO(EventsAddVO);
            Events_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
     * update Events
     *
     * @param Events_UpdateReqVO
     * @return EventsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public EventsRespVO updateEvents(EventsUpdateReqVO Events_UpdateReqVO) {
        EventsRespVO vo = new EventsRespVO();
        if (Events_UpdateReqVO != null) {
            fillingUpdateParams(Events_UpdateReqVO);
            QueryWrapper<EventsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("event_id", Events_UpdateReqVO.getEventId());
            EventsPO po = fromReqVO(Events_UpdateReqVO);
            Events_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
     * delete amount of Events
     *
     * @param Events_BatchReqVO
     * @return number of success deletes
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer deleteEventsList(EventsBatchReqVO Events_BatchReqVO) {
        Integer deleteCount = 0;
        if (Events_BatchReqVO != null) {
            List<String> ids = Events_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<EventsPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("event_id", ids);
                deleteCount = Events_Mapper.delete(queryWrapper);
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
    private EventsPO fromReqVO(EventsAddReqVO queryVO) {
        EventsPO po = new EventsPO();
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
    private EventsPO fromReqVO(EventsUpdateReqVO queryVO) {
        EventsPO po = new EventsPO();
        if (queryVO != null) {
            BeanUtils.copyProperties(queryVO, po);
        }
        return po;
    }


    /**
     * transfer po to vo
     *
     * @param po
     * @return vo
     */
    private EventsRespVO toVO(EventsPO po) {
        EventsRespVO vo = new EventsRespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
     * transfer List<po> to List<vo>
     */
    private List<EventsRespVO> toVOList(List<EventsPO> po) {
        List<EventsRespVO> vo = new ArrayList<>();
        for(int i = 0; i < po.size(); i++){
            vo.add(toVO(po.get(i)));
        }
        return vo;
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingAddParams(EventsAddReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.getEventId())) {
            queryVO.setEventId(String.valueOf(snowFlakeHelper.genId()));
        }
        // TODO: other field operations
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingUpdateParams(EventsUpdateReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.getEventId())) {
            queryVO.setEventId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}