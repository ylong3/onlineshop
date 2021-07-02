package cn.landsall.switchapi.config;

import cn.landsall.switchapi.common.SnowflakeIdWorker;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootWebConfig {

    @Bean
    public SnowflakeIdWorker getSnowflakeIdWorker(){
        return new SnowflakeIdWorker(0,0);
    }

}
