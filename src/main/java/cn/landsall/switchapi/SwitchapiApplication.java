package cn.landsall.switchapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan
public class SwitchapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwitchapiApplication.class, args);
    }

}
