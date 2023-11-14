package CS673.SpringBootStudentEventHub.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author yilin
 * @since 2023-11-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Zipcodes对象", description = "")
public class Zipcodes implements Serializable {

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
