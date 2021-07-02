package cn.landsall.switchapi.service.impl;

import cn.landsall.switchapi.entity.model.GameDetail;
import cn.landsall.switchapi.entity.GameInfo;
import cn.landsall.switchapi.entity.model.GameShop;
import cn.landsall.switchapi.entity.model.PriceDetail;
import cn.landsall.switchapi.mapper.GameInfoMapper;
import cn.landsall.switchapi.service.IGameInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ylong
 * @since 2021-06-16
 */
@Service
public class GameInfoServiceImpl extends ServiceImpl<GameInfoMapper, GameInfo> implements IGameInfoService {

    public List<GameShop> listGameShop(String type,String filterName){
        return baseMapper.SelectShopGameList(type,filterName);
    }
    public GameDetail getOneGameDetail(Long id){
        return baseMapper.SelectOneGameDetailById(id);
    }

    public List<PriceDetail> listPriceDetailById(Long id){
        List<PriceDetail> priceDetailList = baseMapper.SelectPriceDetailListById(id);
        if(priceDetailList.size() == 0)
            return null;
        for (int i=0;i<priceDetailList.size();i++){
            int next = i+1;
            if(next < priceDetailList.size()){
                PriceDetail nextPrice = priceDetailList.get(next);
                PriceDetail curPrice = priceDetailList.get(i);
                curPrice.setPriceChange(curPrice.getPrice().subtract(nextPrice.getPrice()).longValue());
            }else{
                priceDetailList.get(i).setPriceChange(0);
            }
        }
        return priceDetailList;
    }

}
