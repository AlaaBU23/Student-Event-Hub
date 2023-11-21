package CS673.SpringBootStudentEventHub.entity;

import java.time.LocalDate;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Ratings对象", description = "")
public class Ratings implements Serializable {

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
