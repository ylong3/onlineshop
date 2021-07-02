package cn.landsall.switchapi.mapper;

import cn.landsall.switchapi.entity.OrderInfo;
import cn.landsall.switchapi.entity.model.Order;
import cn.landsall.switchapi.entity.model.OrderItemVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ylong
 * @since 2021-06-17
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    public List<Order> selectOrderList(Long userId, Integer min, Integer max);
    public List<OrderItemVo> listOrderItem(String orderNo);


    public Order getOneById(Long id);
}