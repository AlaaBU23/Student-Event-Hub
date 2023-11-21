package CS673.SpringBootStudentEventHub.domain.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "zipCodes对象", description = "")
public class ZipcodesAddReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "zipCodeId", dataType = "String")
    private String zipCodeId;

    @ApiModelProperty(value = "zipCode", dataType = "String")
    private String zipCode;

    @ApiModelProperty(value = "city", dataType = "String")
    private String city;

    @ApiModelProperty(value = "state", dataType = "String")
    private String state;


}