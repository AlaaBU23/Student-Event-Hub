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
@ApiModel(value = "Users对象", description = "")
public class UsersAddReqVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "userId", dataType = "String")
    private String userId;

    @ApiModelProperty(value = "userName", dataType = "String")
    private String userName;

    @ApiModelProperty(value = "password", dataType = "String")
    private String password;

    @ApiModelProperty(value = "email", dataType = "String")
    private String email;

    @ApiModelProperty(value = "zipCode", dataType = "String")
    private String zipCode;

    @ApiModelProperty(value = "firstName", dataType = "String")
    private String firstName;

    @ApiModelProperty(value = "lastName", dataType = "String")
    private String lastName;

    @ApiModelProperty(value = "age", dataType = "String")
    private String age;

    @ApiModelProperty(value = "university", dataType = "String")
    private String university;

    @ApiModelProperty(value = "universityId", dataType = "String")
    private String universityId;

    @ApiModelProperty(value = "description", dataType = "String")
    private String description;


}