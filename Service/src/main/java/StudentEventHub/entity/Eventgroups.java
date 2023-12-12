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
@ApiModel(value = "Eventgroups对象", description = "")
public class Eventgroups implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("group_id")
    private String groupId;

    @TableField("admin_user_id")
    private String adminUserId;


}
