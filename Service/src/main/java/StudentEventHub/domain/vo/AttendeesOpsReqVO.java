package StudentEventHub.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author yuan ju
 * @since 2023-10-30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "AttendeeBatchReqVO批量操作对象", description = "")
public class AttendeesOpsReqVO implements Serializable {


    private static final long serialVersionUID = 1L;

    @ApiModelProperty("Operation status")
    private boolean success = true;

    @ApiModelProperty("number of success")
    private int count = 0;

}
