package cn.landsall.switchapi.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class GamePrice implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer gameId;

    private BigDecimal datePrice;

    private LocalDate date;


}
