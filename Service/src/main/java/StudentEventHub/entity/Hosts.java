package StudentEventHub.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value = "Hosts对象", description = "")
public class Hosts implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private String userId;

    @TableField("event_id")
    private String eventId;


}
