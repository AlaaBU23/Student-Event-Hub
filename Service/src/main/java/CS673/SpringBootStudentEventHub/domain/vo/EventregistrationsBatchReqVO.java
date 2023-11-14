package CS673.SpringBootStudentEventHub.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "EventregistrationBatchReqVO批量操作对象", description = "")
public class EventregistrationsBatchReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id list")
    private List<String> ids;

}
