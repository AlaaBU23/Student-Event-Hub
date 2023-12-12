package StudentEventHub.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Ratings对象", description = "")
public class RatingsUpdateReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ratingId", dataType = "String")
    private String ratingId;

    @ApiModelProperty(value = "ratedUserId", dataType = "String")
    private String ratedUserId;

    @ApiModelProperty(value = "ratingByUserId", dataType = "String")
    private String ratingByUserId;

    @ApiModelProperty(value = "ratingValue", dataType = "int")
    private Integer ratingValue;

    @ApiModelProperty(value = "ratingDate", dataType = "date")
    private LocalDate ratingDate;

    @ApiModelProperty(value = "ratingFor", dataType = "String")
    private String ratingFor;


}