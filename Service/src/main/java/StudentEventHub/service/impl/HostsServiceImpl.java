package StudentEventHub.service.impl;


import StudentEventHub.domain.vo.HostsAddReqVO;
import StudentEventHub.domain.vo.HostsBatchReqVO;
import StudentEventHub.domain.vo.HostsRespVO;
import StudentEventHub.domain.vo.HostsUpdateReqVO;
import StudentEventHub.mapper.HostsMapper;
import StudentEventHub.service.IHostsService;
import StudentEventHub.tools.SnowFlakeHelper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import StudentEventHub.domain.po.HostsPO;
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
public class HostsServiceImpl extends ServiceImpl<HostsMapper, HostsPO> implements IHostsService {

    @Autowired
    private HostsMapper Hosts_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1, 1, 1);

    @Override
    public HostsRespVO getHosts(String id) {
        HostsRespVO vo = new HostsRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<HostsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", id);
            vo = toVO(Hosts_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }


    public Integer deleteHosts(String id) {

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<HostsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", id);
            deleteCount = Hosts_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
     * add Hosts
     *
     * @param HostsAddVO
     * @return HostsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public HostsRespVO addHosts(HostsAddReqVO HostsAddVO) {
        HostsRespVO vo = new HostsRespVO();
        if (HostsAddVO != null) {
            fillingAddParams(HostsAddVO);
            HostsPO po = fromReqVO(HostsAddVO);
            Hosts_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
     * update Hosts
     *
     * @param Hosts_UpdateReqVO
     * @return HostsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public HostsRespVO updateHosts(HostsUpdateReqVO Hosts_UpdateReqVO) {
        HostsRespVO vo = new HostsRespVO();
        if (Hosts_UpdateReqVO != null) {
            fillingUpdateParams(Hosts_UpdateReqVO);
            QueryWrapper<HostsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("user_id", Hosts_UpdateReqVO.getUserId());
            HostsPO po = fromReqVO(Hosts_UpdateReqVO);
            Hosts_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
     * delete amount of Hosts
     *
     * @param Hosts_BatchReqVO
     * @return number of success deletes
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer deleteHostsList(HostsBatchReqVO Hosts_BatchReqVO) {
        Integer deleteCount = 0;
        if (Hosts_BatchReqVO != null) {
            List<String> ids = Hosts_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<HostsPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("user_id", ids);
                deleteCount = Hosts_Mapper.delete(queryWrapper);
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
    private HostsPO fromReqVO(HostsAddReqVO queryVO) {
        HostsPO po = new HostsPO();
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
    private HostsPO fromReqVO(HostsUpdateReqVO queryVO) {
        HostsPO po = new HostsPO();
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
    private HostsRespVO toVO(HostsPO po) {
        HostsRespVO vo = new HostsRespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingAddParams(HostsAddReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.getUserId())) {
            queryVO.setUserId(String.valueOf(snowFlakeHelper.genId()));
        }
        // TODO: other field operations
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingUpdateParams(HostsUpdateReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.getUserId())) {
            queryVO.setUserId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}