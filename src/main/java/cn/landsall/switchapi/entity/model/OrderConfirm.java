package cn.landsall.switchapi.entity.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderConfirm {
    private String OrderNo;

    private Long gameId;

    private Long userId;

    private Integer count;

    private BigDecimal price;

}
