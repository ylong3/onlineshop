package cn.landsall.switchapi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.math.BigDecimal;
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
 * @since 2021-06-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GameInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "game_id", type = IdType.AUTO)
    private Integer gameId;

    private String gameName;

    private Integer sellCount;

    private BigDecimal gamePrice;

    private String gameDetail;

    private String urlCover;

    private String type;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime gmtModified;


}
