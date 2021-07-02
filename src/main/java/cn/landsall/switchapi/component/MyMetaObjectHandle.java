package cn.landsall.switchapi.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class MyMetaObjectHandle implements MetaObjectHandler  {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject,"gmtCreate", LocalDateTime.class,LocalDateTime.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject,"gmtModified", LocalDateTime.class,LocalDateTime.now());
    }
}
