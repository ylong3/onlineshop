package cn.landsall.switchapi.entity.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameShop {
    private Long id;
    private String name;
    private String cover;
    private List<String> tagList;
    private BigDecimal price;
    private int sellCount;
}
