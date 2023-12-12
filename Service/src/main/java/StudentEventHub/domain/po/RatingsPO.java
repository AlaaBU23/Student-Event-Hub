package StudentEventHub.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author yilin
 * @since 2023-10-25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Ratings对象", description = "")
@TableName("ratings")
public class RatingsPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("rating_id")
    private String ratingId;

    @TableField("rated_user_id")
    private String ratedUserId;

    @TableField("rating_by_user_id")
    private String ratingByUserId;

    @TableField("rating_value")
    private Integer ratingValue;

    @TableField("rating_date")
    private LocalDate ratingDate;

    @TableField("rating_for")
    private String ratingFor;


}