package StudentEventHub.domain.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
@ApiModel(value = "Events对象", description = "")
@TableName("events")
public class EventsPO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("event_id")
    private String eventId;

    @TableField("user_id")
    private String userId;

    @TableField("event_name")
    private String eventName;

    @TableField("event_details")
    private String eventDetails;

    @TableField("event_date")
    private LocalDate eventDate;

    @TableField("location")
    private String location;

    @TableField("zip_code")
    private String zipCode;



}