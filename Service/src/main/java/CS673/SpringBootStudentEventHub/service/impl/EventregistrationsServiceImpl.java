package CS673.SpringBootStudentEventHub.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import CS673.SpringBootStudentEventHub.domain.po.EventregistrationsPO;
import CS673.SpringBootStudentEventHub.tools.*;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IEventregistrationsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import CS673.SpringBootStudentEventHub.mapper.EventregistrationsMapper;

/**
 * @author yilin
 * @date 2023-11-13
 */
@Service
@Slf4j
public class EventregistrationsServiceImpl extends ServiceImpl<EventregistrationsMapper, EventregistrationsPO> implements IEventregistrationsService {

    @Autowired
    private EventregistrationsMapper Eventregistrations_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1, 1, 1);

    @Override
    public EventregistrationsRespVO getEventregistrations(String id) {
        EventregistrationsRespVO vo = new EventregistrationsRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<EventregistrationsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("registration_id", id);
            vo = toVO(Eventregistrations_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }


    public Integer deleteEventregistrations(String id) {

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<EventregistrationsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("registration_id", id);
            deleteCount = Eventregistrations_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
     * add Eventregistrations
     *
     * @param EventregistrationsAddVO
     * @return EventregistrationsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public EventregistrationsRespVO addEventregistrations(EventregistrationsAddReqVO EventregistrationsAddVO) {
        EventregistrationsRespVO vo = new EventregistrationsRespVO();
        if (EventregistrationsAddVO != null) {
            fillingAddParams(EventregistrationsAddVO);
            EventregistrationsPO po = fromReqVO(EventregistrationsAddVO);
            Eventregistrations_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
     * update Eventregistrations
     *
     * @param Eventregistrations_UpdateReqVO
     * @return EventregistrationsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public EventregistrationsRespVO updateEventregistrations(EventregistrationsUpdateReqVO Eventregistrations_UpdateReqVO) {
        EventregistrationsRespVO vo = new EventregistrationsRespVO();
        if (Eventregistrations_UpdateReqVO != null) {
            fillingUpdateParams(Eventregistrations_UpdateReqVO);
            QueryWrapper<EventregistrationsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("registration_id", Eventregistrations_UpdateReqVO.getRegistrationId());
            EventregistrationsPO po = fromReqVO(Eventregistrations_UpdateReqVO);
            Eventregistrations_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
     * delete amount of Eventregistrations
     *
     * @param Eventregistrations_BatchReqVO
     * @return number of success deletes
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer deleteEventregistrationsList(EventregistrationsBatchReqVO Eventregistrations_BatchReqVO) {
        Integer deleteCount = 0;
        if (Eventregistrations_BatchReqVO != null) {
            List<String> ids = Eventregistrations_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<EventregistrationsPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("registration_id", ids);
                deleteCount = Eventregistrations_Mapper.delete(queryWrapper);
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
    private EventregistrationsPO fromReqVO(EventregistrationsAddReqVO queryVO) {
        EventregistrationsPO po = new EventregistrationsPO();
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
    private EventregistrationsPO fromReqVO(EventregistrationsUpdateReqVO queryVO) {
        EventregistrationsPO po = new EventregistrationsPO();
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
    private EventregistrationsRespVO toVO(EventregistrationsPO po) {
        EventregistrationsRespVO vo = new EventregistrationsRespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingAddParams(EventregistrationsAddReqVO queryVO) {
        // TODO: 根据特性添加其它字段的定义
        if (StringUtils.isBlank(queryVO.getRegistrationId())) {
            queryVO.setRegistrationId(String.valueOf(snowFlakeHelper.genId()));
        }
        // TODO: other field operations
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingUpdateParams(EventregistrationsUpdateReqVO queryVO) {
        // TODO: 根据特性添加其它字段的定义
        if (StringUtils.isBlank(queryVO.getRegistrationId())) {
            queryVO.setRegistrationId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}