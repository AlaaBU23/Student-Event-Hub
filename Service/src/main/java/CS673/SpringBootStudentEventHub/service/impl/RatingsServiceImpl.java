package CS673.SpringBootStudentEventHub.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import CS673.SpringBootStudentEventHub.domain.po.RatingsPO;
import CS673.SpringBootStudentEventHub.tools.*;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.service.IRatingsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import CS673.SpringBootStudentEventHub.mapper.RatingsMapper;

/**
 * @author yilin
 * @date 2023-11-13
 */
@Service
@Slf4j
public class RatingsServiceImpl extends ServiceImpl<RatingsMapper, RatingsPO> implements IRatingsService {

    @Autowired
    private RatingsMapper Ratings_Mapper;
    private SnowFlakeHelper snowFlakeHelper = new SnowFlakeHelper(1, 1, 1);

    @Override
    public RatingsRespVO getRatings(String id) {
        RatingsRespVO vo = new RatingsRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<RatingsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("rating_id", id);
            vo = toVO(Ratings_Mapper.selectOne(queryWrapper));
        }
        return vo;
    }


    public Integer deleteRatings(String id) {

        Integer deleteCount = 0;
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<RatingsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("rating_id", id);
            deleteCount = Ratings_Mapper.delete(queryWrapper);
        }
        return deleteCount;
    }

    /**
     * add Ratings
     *
     * @param RatingsAddVO
     * @return RatingsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public RatingsRespVO addRatings(RatingsAddReqVO RatingsAddVO) {
        RatingsRespVO vo = new RatingsRespVO();
        if (RatingsAddVO != null) {
            fillingAddParams(RatingsAddVO);
            RatingsPO po = fromReqVO(RatingsAddVO);
            Ratings_Mapper.insert(po);
            vo = toVO(po);
        }
        return vo;
    }


    /**
     * update Ratings
     *
     * @param Ratings_UpdateReqVO
     * @return RatingsRespVO
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public RatingsRespVO updateRatings(RatingsUpdateReqVO Ratings_UpdateReqVO) {
        RatingsRespVO vo = new RatingsRespVO();
        if (Ratings_UpdateReqVO != null) {
            fillingUpdateParams(Ratings_UpdateReqVO);
            QueryWrapper<RatingsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("rating_id", Ratings_UpdateReqVO.getRatingId());
            RatingsPO po = fromReqVO(Ratings_UpdateReqVO);
            Ratings_Mapper.update(po, queryWrapper);
            vo = toVO(po);
        }
        return vo;
    }

    /**
     * delete amount of Ratings
     *
     * @param Ratings_BatchReqVO
     * @return number of success deletes
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Integer deleteRatingsList(RatingsBatchReqVO Ratings_BatchReqVO) {
        Integer deleteCount = 0;
        if (Ratings_BatchReqVO != null) {
            List<String> ids = Ratings_BatchReqVO.getIds();
            if (ids != null && ids.size() > 0) {
                QueryWrapper<RatingsPO> queryWrapper = new QueryWrapper<>();
                queryWrapper.in("rating_id", ids);
                deleteCount = Ratings_Mapper.delete(queryWrapper);
            }
        }
        return deleteCount;
    }
    public Double CalculateRating(String id){
        Double rate_ini = 0.0;
        Double sum = 0.0;
        RatingsRespVO vo = new RatingsRespVO();
        if (StringUtils.isNotBlank(id)) {
            QueryWrapper<RatingsPO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("rated_user_id", id);
            queryWrapper.select("rating_value as RV");
            List<Map<String, Object>> results = Ratings_Mapper.selectMaps(queryWrapper);
            for (Map<String, Object> row : results) {
                System.out.println(row);
                Integer rate = (Integer) row.get("RV");
                sum+=rate;
            }
            rate_ini = sum/results.size();
        }
        return rate_ini;
    }

    /**
     * addReqVO转po
     *
     * @param queryVO
     * @return po
     */
    private RatingsPO fromReqVO(RatingsAddReqVO queryVO) {
        RatingsPO po = new RatingsPO();
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
    private RatingsPO fromReqVO(RatingsUpdateReqVO queryVO) {
        RatingsPO po = new RatingsPO();
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
    private RatingsRespVO toVO(RatingsPO po) {
        RatingsRespVO vo = new RatingsRespVO();
        if (po != null) {
            BeanUtils.copyProperties(po, vo);
        }
        return vo;
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingAddParams(RatingsAddReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.getRatingId())) {
            queryVO.setRatingId(String.valueOf(snowFlakeHelper.genId()));
        }
        // TODO: other field operations
    }

    /**
     * @param queryVO
     * @return
     */
    private void fillingUpdateParams(RatingsUpdateReqVO queryVO) {
        // TODO: Add definitions for other fields based on characteristics
        if (StringUtils.isBlank(queryVO.getRatingId())) {
            queryVO.setRatingId(String.valueOf(snowFlakeHelper.genId()));
        }
    }
}