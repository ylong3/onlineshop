package cn.landsall.switchapi.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDetail {
    private LocalDate date;
    private BigDecimal price;
    private float priceChange;

}
