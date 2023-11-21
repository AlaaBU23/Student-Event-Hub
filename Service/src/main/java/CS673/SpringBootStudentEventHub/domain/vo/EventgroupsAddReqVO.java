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
@ApiModel(value = "EventGroups对象", description = "")
public class EventgroupsAddReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "groupId", dataType = "String")
    private String groupId;

    @ApiModelProperty(value = "adminUserId", dataType = "String")
    private String adminUserId;


}