package cn.landsall.switchapi.service.impl;

import cn.landsall.switchapi.entity.OrderInfo;
import cn.landsall.switchapi.entity.model.Order;
import cn.landsall.switchapi.entity.model.OrderItemVo;
import cn.landsall.switchapi.mapper.OrderInfoMapper;
import cn.landsall.switchapi.service.IOrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ylong
 * @since 2021-06-17
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements IOrderInfoService {
    public List<Order> selectOrderList(Long userId, Integer min, Integer max){
        return baseMapper.selectOrderList(userId, min, max);
    }
    public List<OrderItemVo> listOrderItem(String orderNo){
        return baseMapper.listOrderItem(orderNo);
    }
    public Order getOneById(Long id){
        return baseMapper.getOneById(id);
    }


}
