package StudentEventHub.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel(value = "Groupmembers对象", description = "")
@TableName("groupmembers")
public class GroupmembersPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("group_id")
    private String groupId;

    @TableField("user_id")
    private String userId;


}