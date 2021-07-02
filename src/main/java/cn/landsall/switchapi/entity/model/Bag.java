package cn.landsall.switchapi.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bag {
    private Long id;
    private Long gameId;
    private String name;
    private BigDecimal price;
    private String cover;
    private Integer count;
    private Boolean isSelect;
}
