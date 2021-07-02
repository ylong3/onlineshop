package cn.landsall.switchapi.controller;


import cn.landsall.switchapi.entity.GameInfo;
import cn.landsall.switchapi.entity.UserInfo;
import cn.landsall.switchapi.entity.model.GameDetail;
import cn.landsall.switchapi.entity.model.GameShop;
import cn.landsall.switchapi.entity.model.PriceDetail;
import cn.landsall.switchapi.service.impl.GameInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ylong
 * @since 2021-06-16
 */
@Controller
@RequestMapping("/gameInfo")
public class GameInfoController {
    @Autowired
    private GameInfoServiceImpl gameInfoService;


    @GetMapping("/gameShopList")
    @ResponseBody
    public List<GameShop> gameShopList(String type,String filterName){
        return gameInfoService.listGameShop(type,filterName);
    }

    @GetMapping("/gameDetail/{id}")
    @ResponseBody
    public GameDetail gameDetail(@PathVariable Long id){
        return gameInfoService.getOneGameDetail(id);
    }

    @GetMapping("/priceDetail/{id}")
    @ResponseBody
    public List<PriceDetail> priceDetailList(@PathVariable Long id){
        return gameInfoService.listPriceDetailById(id);
    }




    @ResponseBody
    @GetMapping("/cover/{id}")
    public void getImage(HttpSession session, HttpServletResponse response, @PathVariable Long id) throws IOException {
        response.setContentType("image/png");
        //获得输出流
        ServletOutputStream out = response.getOutputStream();
        //TODO 获得输出result
        GameInfo gameInfo = gameInfoService.getById(id);
        String picName = "avatar.jpg";
        if(gameInfo == null)
            return;
        else if(!"".equals(gameInfo.getUrlCover())){
            picName = gameInfo.getUrlCover();
        }
        String path = ResourceUtils.getURL("classpath:").getPath() + "upload/cover/";
        File file = new File(path+picName);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes) != -1){
            out.write(bytes);
        }
        //输出图片
        out.flush();
        //关闭响应输出流
        out.close();
    }



}

