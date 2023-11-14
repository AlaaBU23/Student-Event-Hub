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
@ApiModel(value = "Eventregistrations对象", description = "")
public class EventregistrationsPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("registration_id")
    private String registrationId;

    @TableField("event_id")
    private String eventId;

    @TableField("user_id")
    private String userId;

    @TableField("registration_status")
    private String registrationStatus;

    @TableField("confirmation_email_sent")
    private Boolean confirmationEmailSent;


}