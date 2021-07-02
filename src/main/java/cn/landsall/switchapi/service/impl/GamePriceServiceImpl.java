package cn.landsall.switchapi.service.impl;

import cn.landsall.switchapi.entity.GamePrice;
import cn.landsall.switchapi.mapper.GamePriceMapper;
import cn.landsall.switchapi.service.IGamePriceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ylong
 * @since 2021-06-16
 */
@Service
public class GamePriceServiceImpl extends ServiceImpl<GamePriceMapper, GamePrice> implements IGamePriceService {

}
