package cn.landsall.switchapi.service.impl;

import cn.landsall.switchapi.entity.OrderItem;
import cn.landsall.switchapi.mapper.OrderItemMapper;
import cn.landsall.switchapi.service.IOrderItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ylong
 * @since 2021-07-02
 */
@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItem> implements IOrderItemService {

}
