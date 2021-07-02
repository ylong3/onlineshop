package cn.landsall.switchapi.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemVo {
    private Long id;
    private Long gameId;
    private String gameName;
    private BigDecimal gamePrice;
    private Long count;
    private String cover;

}
