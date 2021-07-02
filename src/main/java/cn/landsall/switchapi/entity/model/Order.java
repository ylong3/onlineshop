package cn.landsall.switchapi.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private String orderNo;
    private Long gameId;
    private BigDecimal gamePrice;
    private int count;
    private String cover;
    private String username;
    private String gameName;
    private LocalDateTime orderTime;
    private int state;
}
