package CS673.SpringBootStudentEventHub.service;

import com.baomidou.mybatisplus.extension.service.IService;

import CS673.SpringBootStudentEventHub.domain.po.RatingsPO;
import CS673.SpringBootStudentEventHub.domain.vo.*;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import CS673.SpringBootStudentEventHub.entity.Ratings;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import CS673.SpringBootStudentEventHub.mapper.RatingsMapper;

/**
 * <p>
 * $!{table.comment} service class
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
public interface IRatingsService extends IService<RatingsPO> {
    public RatingsRespVO getRatings(String id);

    public Integer deleteRatings(String id);

    public RatingsRespVO addRatings(RatingsAddReqVO RatingsAddVO);

    public RatingsRespVO updateRatings(RatingsUpdateReqVO Ratings_UpdateReqVO);

    public Integer deleteRatingsList(RatingsBatchReqVO Ratings_BatchReqVO);

}