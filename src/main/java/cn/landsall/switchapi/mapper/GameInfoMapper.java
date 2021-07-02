package cn.landsall.switchapi.mapper;

import cn.landsall.switchapi.entity.model.GameDetail;
import cn.landsall.switchapi.entity.GameInfo;
import cn.landsall.switchapi.entity.model.GameShop;
import cn.landsall.switchapi.entity.model.PriceDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ylong
 * @since 2021-06-16
 */
public interface GameInfoMapper extends BaseMapper<GameInfo> {
    public List<GameShop> SelectShopGameList(String type,String filterName);
    public GameDetail SelectOneGameDetailById(Long id);
    public List<PriceDetail> SelectPriceDetailListById(Long id);
}
