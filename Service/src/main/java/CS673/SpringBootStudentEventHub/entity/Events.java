package CS673.SpringBootStudentEventHub.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@ApiModel(value = "Events对象", description = "")
public class Events implements Serializable {

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

    @TableField("zip_code_id")
    private String zipCodeId;

    @TableField("fee")
    private BigDecimal fee;


}
