package CS673.SpringBootStudentEventHub.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.*;

/**
 * @author yuan ju
 * @since 2023-10-30
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "AttendeePO对象", description = "考勤日度报表")
@TableName("attendees")
public class AttendeesPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("user_id")
    private String userId;

    @TableField("event_id")
    private String eventId;

    @TableField("registration_status")
    private String registrationStatus;

    @TableField("attendee_rating")
    private Integer attendeeRating;

}
