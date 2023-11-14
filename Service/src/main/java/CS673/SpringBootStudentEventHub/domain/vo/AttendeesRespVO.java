package CS673.SpringBootStudentEventHub.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

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
@ApiModel(value = "Attendee对象", description = "")
public class AttendeesRespVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "userId", dataType = "String")
    private String userId;

    @ApiModelProperty(value = "String", dataType = "String")
    private String eventId;

    @ApiModelProperty(value = "registrationStatus", dataType = "String")
    private String registrationStatus;

    @ApiModelProperty(value = "attendeeRating", dataType = "int")
    private Integer attendeeRating;


}
