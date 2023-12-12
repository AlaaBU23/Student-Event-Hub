package StudentEventHub.service;

import StudentEventHub.domain.vo.RatingsAddReqVO;
import StudentEventHub.domain.vo.RatingsBatchReqVO;
import StudentEventHub.domain.vo.RatingsRespVO;
import StudentEventHub.domain.vo.RatingsUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

import StudentEventHub.domain.po.RatingsPO;
import StudentEventHub.domain.vo.*;

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

    public Double CalculateRating(String id);
}