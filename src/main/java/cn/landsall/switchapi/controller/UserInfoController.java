package cn.landsall.switchapi.controller;


import cn.landsall.switchapi.entity.UserInfo;
import cn.landsall.switchapi.entity.model.Collect;
import cn.landsall.switchapi.service.impl.RelationUserGameServiceImpl;
import cn.landsall.switchapi.service.impl.UserInfoServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ylong
 * @since 2021-06-19
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    private UserInfoServiceImpl userInfoService;
    @Autowired
    public RelationUserGameServiceImpl relationUserGameService;


    @PostMapping("/avatar/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file,Long id){
        try {
            String path = ResourceUtils.getURL("classpath:").getPath() + "upload/avatar/";
            //创建文件夹
            File Dir = new File(path);
            if(!Dir.exists()){
                Dir.mkdirs();
            }

            UUID uuid = UUID.randomUUID();
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            String fileNameUUID = uuid + "." +suffix;
            File dest = new File(path + fileNameUUID);
            System.out.println(path);
            System.out.println(fileNameUUID);

            file.transferTo(dest);
            UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<UserInfo>();
            updateWrapper.eq("id",id);
            updateWrapper.set("avatar",fileNameUUID);
            userInfoService.update(updateWrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功";
    }

    @ResponseBody
    @GetMapping("/avatar/{id}")
    public void getImage(HttpSession session, HttpServletResponse response, @PathVariable Long id) throws IOException {
        response.setContentType("image/png");
        //获得输出流
        ServletOutputStream out = response.getOutputStream();
        //TODO 获得输出result
        UserInfo userInfo = userInfoService.getById(id);
        String picName = "avatar.jpg";
        if(userInfo == null)
            return;
        else if(!(userInfo.getAvatar() == null) & !"".equals(userInfo.getAvatar()) ){
            picName = userInfo.getAvatar();
        }
        String path = ResourceUtils.getURL("classpath:").getPath() + "upload/avatar/";
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

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserInfo getById(@PathVariable Long id){
        return userInfoService.getById(id);
    }

    @PostMapping("/user/edit")
    @ResponseBody
    public String edit(UserInfo userInfo){
        UpdateWrapper<UserInfo> updateWrapper = new UpdateWrapper<UserInfo>();
        updateWrapper.eq("id",userInfo.getId());
        updateWrapper.set("username",userInfo.getUsername());
        updateWrapper.set("sex",userInfo.getSex());
        updateWrapper.set("birth",userInfo.getBirth());
        updateWrapper.set("tel",userInfo.getTel());
        updateWrapper.set("email",userInfo.getEmail());

        userInfoService.update(updateWrapper);

        return "succeed";
    }

    @GetMapping("/collect/list/{userId}")
    @ResponseBody
    public List<Collect> collectList(@PathVariable Long userId){
        return relationUserGameService.SelectCollectByUserId(userId);
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(String username,String password){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);

        UserInfo userInfo = userInfoService.getOne(queryWrapper);
        if(userInfo != null)
            return userInfo.getId()+"";
        else
            return "failed";
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(String username,String password){
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<UserInfo>();
        queryWrapper.eq("username",username);

        UserInfo userInfo = userInfoService.getOne(queryWrapper);

        if(userInfo != null){
            return "failed";
        }else{
            userInfo = new UserInfo();
            userInfo.setUsername(username);
            userInfo.setPassword(password);
            userInfoService.save(userInfo);
            return  userInfoService.getOne(queryWrapper).getId() + "";
        }
    }


}

