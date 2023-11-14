package CS673.SpringBootStudentEventHub.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "ZipcodesOps批量操作对象", description = "")
public class ZipcodesOpsResVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Operation status")
    private boolean success = true;

    @ApiModelProperty("number of success")
    private int count = 0;

}
