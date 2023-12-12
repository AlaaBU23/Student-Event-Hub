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
@ApiModel(value = "GroupMembers对象", description = "")
public class GroupmembersUpdateReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "groupId", dataType = "String")
    private String groupId;

    @ApiModelProperty(value = "userId", dataType = "String")
    private String userId;

}