package CS673.SpringBootStudentEventHub.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Hosts对象", description = "")
public class HostsUpdateReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "userId", dataType = "String")
    private String userId;

    @ApiModelProperty(value = "eventId", dataType = "String")
    private String eventId;

}