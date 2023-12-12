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
@ApiModel(value = "Users对象", description = "")
@TableName("users")
public class UsersPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private String userId;

    @TableField("first_name")
    private String firstName;

    @TableField("last_name")
    private String lastName;

    @TableField("user_name")
    private String userName;

    @TableField("password")
    private String password;

    @TableField("email")
    private String email;

    @TableField("age")
    private String age;

    @TableField("university")
    private String university;

    @TableField("university_id")
    private String universityId;

    @TableField("zip_code")
    private String zipCode;

    @TableField("description")
    private String description;


}
