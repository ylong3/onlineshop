package cn.landsall.switchapi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author ylong
 * @since 2021-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long userId;

    private String orderNo;

    private LocalDateTime finishTime;

    private LocalDateTime sendTime;


    private LocalDateTime payTime;

    /**
     * 状态1-7
     */
    private Integer state;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime gmtModified;


}
