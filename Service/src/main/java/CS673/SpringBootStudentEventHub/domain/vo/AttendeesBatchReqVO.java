package CS673.SpringBootStudentEventHub.domain.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yuan ju
 * @since 2023-10-30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "AttendeeBatchReqVO批量操作对象", description = "")
public class AttendeesBatchReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id list")
    private List<String> ids;

}
