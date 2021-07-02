package cn.landsall.switchapi.controller;


import cn.landsall.switchapi.entity.BagInfo;
import cn.landsall.switchapi.entity.model.Bag;
import cn.landsall.switchapi.service.impl.BagInfoServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ylong
 * @since 2021-06-18
 */
@Controller
@RequestMapping("/bagInfo")
public class BagInfoController {
    @Autowired
    private BagInfoServiceImpl bagInfoService;

    @GetMapping("/list/{userId}")
    @ResponseBody
    public List<Bag> list(@PathVariable Long userId,Boolean filterSelect){
        return bagInfoService.listByUserId(userId,filterSelect);
    }

    @PostMapping("/clear/{userId}")
    @ResponseBody
    public String clear(@PathVariable Long userId){
        QueryWrapper<BagInfo> queryWrapper = new QueryWrapper<BagInfo>();
        queryWrapper.eq("user_id",userId);
        bagInfoService.remove(queryWrapper);
        return "succeed";
    }

    @GetMapping("/insert")
    @ResponseBody
    public String insertOne(Long userId,Long gameId){
        QueryWrapper<BagInfo> queryWrapper = new QueryWrapper<BagInfo>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("game_id",gameId);

        BagInfo one = bagInfoService.getOne(queryWrapper);
        if(one == null){
            BagInfo bagInfo = new BagInfo();
            bagInfo.setGameId(gameId);
            bagInfo.setUserId(userId);
            bagInfo.setCount(1);
            bagInfoService.insertOne(bagInfo);
            return "succeed";
        }else{
            return "has";
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestParam(required = true) Long userId,@RequestParam(required = true) Long gameId,@RequestParam(required = true)Integer count,@RequestParam(required = true) Boolean isSelect){
        UpdateWrapper<BagInfo> wrapper = new UpdateWrapper<BagInfo>();
        wrapper.eq("user_id",userId);
        wrapper.eq("game_id",gameId);
        wrapper.set("count",count);
        wrapper.set("is_select",isSelect);
        bagInfoService.update(wrapper);
        return "succeed";
    }





}

