package StudentEventHub.service.impl;


import StudentEventHub.domain.vo.ZipcodesAddReqVO;
import StudentEventHub.domain.vo.ZipcodesBatchReqVO;
import StudentEventHub.domain.vo.ZipcodesRespVO;
import StudentEventHub.domain.vo.ZipcodesUpdateReqVO;
import StudentEventHub.mapper.ZipcodesMapper;
import StudentEventHub.tools.SnowFlakeHelper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import StudentEventHub.domain.po.ZipcodesPO;
import StudentEventHub.tools.*;
import StudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import StudentEventHub.service.IZipcodesService;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * @author yilin
 * @date 2023-11-13
 */
@Service
@Slf4j
public class ZipcodesServiceImpl extends ServiceImpl<ZipcodesMapper, ZipcodesPO> implements IZipcodesService {

    @Autowired
    private ZipcodesMapper Zipcodes_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1, 1, 1);

    @Override
    public ZipcodesRespVO getZipcodes(String id) {
        ZipcodesRespVO vo = new ZipcodesRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<ZipcodesPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("zip_code_id", id);
            vo = toVO(Zipcodes_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }


    public Integer deleteZipcodes(String id) {

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<ZipcodesPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("zip_code_id", id);
            deleteCount = Zipcodes_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
     * add Zipcodes
     *
     * @param ZipcodesAddVO
     * @return ZipcodesRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ZipcodesRespVO addZipcodes(ZipcodesAddReqVO ZipcodesAddVO) {
        ZipcodesRespVO vo = new ZipcodesRespVO();
        if (ZipcodesAddVO != null) {
            fillingAddParams(ZipcodesAddVO);
            ZipcodesPO po = fromReqVO(ZipcodesAddVO);
            Zipcodes_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
     * update Zipcodes
     *
     * @param Zipcodes_UpdateReqVO
     * @return ZipcodesRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ZipcodesRespVO updateZipcodes(ZipcodesUpdateReqVO Zipcodes_UpdateReqVO) {
        ZipcodesRespVO vo = new ZipcodesRespVO();
        if (Zipcodes_UpdateReqVO != null) {
            fillingUpdateParams(Zipcodes_UpdateReqVO);
            QueryWrapper<ZipcodesPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("zip_code_id", Zipcodes_UpdateReqVO.getZipCodeId());
            ZipcodesPO po = fromReqVO(Zipcodes_UpdateReqVO);
            Zipcodes_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
     * delete amount of Zipcodes
     *
     * @param Zipcodes_BatchReqVO
     * @return number of success deletes
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer deleteZipcodesList(ZipcodesBatchReqVO Zipcodes_BatchReqVO) {
        Integer deleteCount = 0;
        if (Zipcodes_BatchReqVO != null) {
            List<String> ids = Zipcodes_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<ZipcodesPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("zip_code_id", ids);
                deleteCount = Zipcodes_Mapper.delete(queryWrapper);
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
    private ZipcodesPO fromReqVO(ZipcodesAddReqVO queryVO) {
        ZipcodesPO po = new ZipcodesPO();
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
    private ZipcodesPO fromReqVO(ZipcodesUpdateReqVO queryVO) {
        ZipcodesPO po = new ZipcodesPO();
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
    private ZipcodesRespVO toVO(ZipcodesPO po) {
        ZipcodesRespVO vo = new ZipcodesRespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingAddParams(ZipcodesAddReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.getZipCodeId())) {
            queryVO.setZipCodeId(String.valueOf(snowFlakeHelper.genId()));
        }
        // TODO: other field operations
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingUpdateParams(ZipcodesUpdateReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.getZipCodeId())) {
            queryVO.setZipCodeId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}