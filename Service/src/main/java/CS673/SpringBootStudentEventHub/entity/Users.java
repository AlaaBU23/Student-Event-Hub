package CS673.SpringBootStudentEventHub.entity;

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
@ApiModel(value = "Users对象", description = "")
public class Users implements Serializable {

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

    @TableField("zip_code_id")
    private String zipCodeId;

    @TableField("description")
    private String description;


}
