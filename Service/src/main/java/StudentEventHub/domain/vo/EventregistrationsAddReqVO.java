package StudentEventHub.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "EventRegistrations对象", description = "")
public class EventregistrationsAddReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "registrationId", dataType = "String")
    private String registrationId;

    @ApiModelProperty(value = "eventId", dataType = "String")
    private String eventId;

    @ApiModelProperty(value = "userId", dataType = "String")
    private String userId;

    @ApiModelProperty(value = "registrationStatus", dataType = "String")
    private String registrationStatus;

    @ApiModelProperty(value = "confirmationEmailSent", dataType = "Boolean")
    private Boolean confirmationEmailSent;


}