package cn.landsall.switchapi.entity.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderVo {
    private String orderNo;
    private Integer state;
    private LocalDateTime createTime;
    private LocalDateTime payTime;
    private LocalDateTime sendTime;
    private LocalDateTime finishTime;
    private BigDecimal totalPrice;

    private Long userId;
    private String userName;
    private String address;


    private List<OrderItemVo> orderItemVoList;


}

