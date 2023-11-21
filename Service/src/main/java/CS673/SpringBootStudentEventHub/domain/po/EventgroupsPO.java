package CS673.SpringBootStudentEventHub.domain.po;

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
@ApiModel(value = "EventGroups对象", description = "")
@TableName("eventgroups")
public class EventgroupsPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("group_id")
    private String groupId;

    @TableField("admin_user_id")
    private String adminUserId;

}