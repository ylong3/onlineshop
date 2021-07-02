package cn.landsall.switchapi.controller;


import cn.landsall.switchapi.common.SnowflakeIdWorker;
import cn.landsall.switchapi.entity.BagInfo;
import cn.landsall.switchapi.entity.OrderInfo;
import cn.landsall.switchapi.entity.OrderItem;
import cn.landsall.switchapi.entity.model.Order;
import cn.landsall.switchapi.entity.model.OrderConfirm;
import cn.landsall.switchapi.service.impl.BagInfoServiceImpl;
import cn.landsall.switchapi.service.impl.OrderInfoServiceImpl;
import cn.landsall.switchapi.service.impl.OrderItemServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ylong
 * @since 2021-06-17
 */
@Controller
@RequestMapping("/orderInfo")
public class OrderInfoController {
    @Autowired
    private SnowflakeIdWorker snowflakeIdWorker;
    @Autowired
    private OrderInfoServiceImpl orderInfoService;
    @Autowired
    private BagInfoServiceImpl bagInfoService;
    @Autowired
    private OrderItemServiceImpl orderItemService;

    @GetMapping("/list/{userId}")
    @ResponseBody
    public List<OrderInfo> orderList(@PathVariable Long userId, int min, int max) {
        QueryWrapper<OrderInfo> queryWrapper = new QueryWrapper<OrderInfo>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.between("state",min,max);
        return orderInfoService.list(queryWrapper);
    }

    @PostMapping("/create")
    @ResponseBody
    @Transactional
    public String create(@RequestBody String params) {
        System.out.println(params);
        JSONObject data = JSONObject.parseObject(params);
        JSONObject paramsObj = data.getJSONObject("params");

        String idStr = paramsObj.getString("userId");
        String listStr = paramsObj.getString("orderItemList");
        Integer userId = (Integer) JSONObject.parse(idStr);

        List<OrderItem> orderItemList = JSONArray.parseArray(listStr, OrderItem.class);
        //@RequestParam("orderItemList")OrderItem[] orderItemList,Long userId
        String orderNo = snowflakeIdWorker.nextId()+"";
        System.out.println(orderNo);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(orderNo);
        orderInfo.setUserId(Long.valueOf(userId));
        orderInfoService.save(orderInfo);
        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrderNo(orderNo);
        }
        orderItemService.saveBatch(orderItemList);

        QueryWrapper<BagInfo> queryWrapper = new QueryWrapper<BagInfo>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("is_select",true);

        bagInfoService.remove(queryWrapper);
        return "succeed";
    }

    /*@PostMapping("/create")
    @ResponseBody
    public String create(ArrayList <OrderItem> orderItemList,Long userId) {
        for (OrderItem orderItem : orderItemList) {
            System.out.println(orderItem);
        }
        System.out.println(orderItemList.size());
        System.out.println(userId);
        //@RequestParam("orderItemList")OrderItem[] orderItemList,Long userId
        long nextId = snowflakeIdWorker.nextId();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderNo(nextId+"");
        orderInfo.setUserId(userId);
        orderInfoService.save(orderInfo);
        System.out.println(userId);

        orderItemService.saveBatch(orderItemList);

        QueryWrapper<BagInfo> queryWrapper = new QueryWrapper<BagInfo>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("isSelect",true);

        bagInfoService.remove(queryWrapper);
        return "succeed";
    }*/

    @GetMapping("/order")
    @ResponseBody
    public Order getByOne(Long orderId) {
        return orderInfoService.getOneById(orderId);
    }

}

