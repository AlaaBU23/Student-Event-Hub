package CS673.SpringBootStudentEventHub.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Events对象", description = "")
public class EventsUpdateReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "eventId", dataType = "String")
    private String eventId;

    @ApiModelProperty(value = "userId", dataType = "String")
    private String userId;

    @ApiModelProperty(value = "eventName", dataType = "String")
    private String eventName;

    @ApiModelProperty(value = "eventDetails", dataType = "String")
    private String eventDetails;

    @ApiModelProperty(value = "eventDate", dataType = "date")
    private LocalDate eventDate;

    @ApiModelProperty(value = "location", dataType = "String")
    private String location;

    @ApiModelProperty(value = "zipCodeId", dataType = "String")
    private String zipCodeId;

    @ApiModelProperty(value = "fee", dataType = "BigDecimal")
    private BigDecimal fee;

}