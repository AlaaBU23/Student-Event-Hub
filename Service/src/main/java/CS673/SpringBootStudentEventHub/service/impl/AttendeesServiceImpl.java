package CS673.SpringBootStudentEventHub.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import CS673.SpringBootStudentEventHub.domain.po.AttendeesPO;
import CS673.SpringBootStudentEventHub.tools.*;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IAttendeesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import CS673.SpringBootStudentEventHub.mapper.AttendeesMapper;

/**
 * @author yilin
 * @date 2023-11-13
 */
@Service
@Slf4j
public class AttendeesServiceImpl extends ServiceImpl<AttendeesMapper, AttendeesPO> implements IAttendeesService {

    @Autowired
    private AttendeesMapper Attendees_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1, 1, 1);

    @Override
    public AttendeesRespVO getAttendees(String id) {
        AttendeesRespVO vo = new AttendeesRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<AttendeesPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            vo = toVO(Attendees_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }


    public Integer deleteAttendees(String id) {

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<AttendeesPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", id);
            deleteCount = Attendees_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
     * add Attendees
     *
     * @param AttendeesAddVO
     * @return AttendeesRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AttendeesRespVO addAttendees(AttendeesAddReqVO AttendeesAddVO) {
        AttendeesRespVO vo = new AttendeesRespVO();
        if (AttendeesAddVO != null) {
            fillingAddParams(AttendeesAddVO);
            AttendeesPO po = fromReqVO(AttendeesAddVO);
            Attendees_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
     * update Attendees
     *
     * @param Attendees_UpdateReqVO
     * @return AttendeesRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public AttendeesRespVO updateAttendees(AttendeesUpdateReqVO Attendees_UpdateReqVO) {
        AttendeesRespVO vo = new AttendeesRespVO();
        if (Attendees_UpdateReqVO != null) {
            fillingUpdateParams(Attendees_UpdateReqVO);
            QueryWrapper<AttendeesPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("AttendeesId", Attendees_UpdateReqVO.getUserId());
            AttendeesPO po = fromReqVO(Attendees_UpdateReqVO);
            Attendees_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
     * delete amount of Attendees
     *
     * @param Attendees_BatchReqVO
     * @return number of success deletes
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer deleteAttendeesList(AttendeesBatchReqVO Attendees_BatchReqVO) {
        Integer deleteCount = 0;
        if (Attendees_BatchReqVO != null) {
            List<String> ids = Attendees_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<AttendeesPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("AttendeesId", ids);
                deleteCount = Attendees_Mapper.delete(queryWrapper);
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
    private AttendeesPO fromReqVO(AttendeesAddReqVO queryVO) {
        AttendeesPO po = new AttendeesPO();
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
    private AttendeesPO fromReqVO(AttendeesUpdateReqVO queryVO) {
        AttendeesPO po = new AttendeesPO();
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
    private AttendeesRespVO toVO(AttendeesPO po) {
        AttendeesRespVO vo = new AttendeesRespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingAddParams(AttendeesAddReqVO queryVO) {
        // TODO: 根据特性添加其它字段的定义
        if (StringUtils.isBlank(queryVO.getUserId())) {
            queryVO.setUserId(String.valueOf(snowFlakeHelper.genId()));
        }
        // TODO: other field operations
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingUpdateParams(AttendeesUpdateReqVO queryVO) {
        // TODO: 根据特性添加其它字段的定义
        if (StringUtils.isBlank(queryVO.getUserId())) {
            queryVO.setUserId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}