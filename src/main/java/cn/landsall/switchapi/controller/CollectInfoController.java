package cn.landsall.switchapi.controller;


import cn.landsall.switchapi.entity.BagInfo;
import cn.landsall.switchapi.entity.CollectInfo;
import cn.landsall.switchapi.entity.RelationUserGame;
import cn.landsall.switchapi.service.impl.BagInfoServiceImpl;
import cn.landsall.switchapi.service.impl.CollectInfoServiceImpl;
import cn.landsall.switchapi.service.impl.RelationUserGameServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ylong
 * @since 2021-06-18
 */
@Controller
@RequestMapping("/collectInfo")
public class CollectInfoController {
    @Autowired
    private RelationUserGameServiceImpl relationUserGameService;

    @GetMapping("/change")
    @ResponseBody
    public String insertOne(Long userId,Long gameId){
        QueryWrapper<RelationUserGame> queryWrapper = new QueryWrapper<RelationUserGame>();
        queryWrapper.eq("user_id",userId);
        queryWrapper.eq("game_id",gameId);

        RelationUserGame one = relationUserGameService.getOne(queryWrapper);
        if(one == null){
            RelationUserGame collectInfo = new RelationUserGame();
            collectInfo.setGameId(gameId);
            collectInfo.setUserId(userId);
            relationUserGameService.save(collectInfo);
            return "add";
        }else{
            relationUserGameService.remove(queryWrapper);
            return "remove";
        }
    }


}

