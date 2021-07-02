package cn.landsall.switchapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public String Index(){
        return "index";
    }



}
