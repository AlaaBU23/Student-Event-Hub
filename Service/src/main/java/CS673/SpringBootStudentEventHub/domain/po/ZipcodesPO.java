package CS673.SpringBootStudentEventHub.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yilin
 * @since 2023-10-25
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "zipCodes对象", description = "")
public class ZipcodesPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("zip_code_id")
    private String zipCodeId;

    @TableField("zip_code")
    private String zipCode;

    @TableField("city")
    private String city;

    @TableField("state")
    private String state;


}