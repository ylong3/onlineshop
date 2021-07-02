package cn.landsall.switchapi.entity.model;

import cn.landsall.switchapi.entity.GamePrice;
import cn.landsall.switchapi.entity.TagInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDetail {
    private Long id;
    private String name;
    private String detail;
    private BigDecimal price;
    private int sellCount;
    private String cover;

    private List<TagInfo> tagList;
}
