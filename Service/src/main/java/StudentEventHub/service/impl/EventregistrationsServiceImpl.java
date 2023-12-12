package StudentEventHub.service.impl;


import StudentEventHub.domain.vo.EventregistrationsAddReqVO;
import StudentEventHub.domain.vo.EventregistrationsBatchReqVO;
import StudentEventHub.domain.vo.EventregistrationsRespVO;
import StudentEventHub.domain.vo.EventregistrationsUpdateReqVO;
import StudentEventHub.mapper.EventregistrationsMapper;
import StudentEventHub.service.IEventregistrationsService;
import StudentEventHub.tools.SnowFlakeHelper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import StudentEventHub.domain.po.EventregistrationsPO;
import StudentEventHub.tools.*;
import StudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;

import java.util.List;

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
        // TODO: Add definitions for other fields based on characteristics
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
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.getRegistrationId())) {
            queryVO.setRegistrationId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}