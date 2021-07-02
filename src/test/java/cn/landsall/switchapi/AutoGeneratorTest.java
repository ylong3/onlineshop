package cn.landsall.switchapi;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AutoGeneratorTest {
    @Test
    void contextLoads() {
        GeneratorOne("order_item",true);
        //GeneratorOne("game_price",false);
        //GeneratorOne("relation_game_tag",false);
        //GeneratorOne("tag_info",false);
        //GeneratorOne("relation_user_game",false);
        //GeneratorOne("order_info",true);
        //GeneratorOne("bag_info",false);
       // GeneratorOne("collect_info",false);
       // GeneratorOne("user_info",false);



    }

    public void GeneratorOne(String tableName,boolean hasAutoInsert){
        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");    //输出路径
        globalConfig.setAuthor("ylong");
        globalConfig.setOpen(false);    //完成后是否打开资源管理器
        globalConfig.setFileOverride(true);    //是否覆盖原文件

        //数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://42.192.238.52:3306/switchgame?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("Cyl032512+");
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setDbType(DbType.MYSQL);

        //包的配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("cn.landsall.switchapi");
        packageConfig.setModuleName("");  //模块名
        //packageConfig.setMapper("mapper");
        //packageConfig.setController("controller");
        //packageConfig.setEntity("entity");
        //packageConfig.setService("service");

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude(tableName); //要映射的表名
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);  //表映射到实体的命名策略
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);  //表字段映射到实体的命名策略
        //strategyConfig.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategyConfig.setEntityLombokModel(true);  //是否为lombok模型
        //strategyConfig.setRestControllerStyle(true);  //是否为RestController
        //strategyConfig.setLogicDeleteFieldName("is_deleted")  //逻辑删除属性名称

        //自动填充配置
        if(hasAutoInsert){
            TableFill create_time = new TableFill("gmt_create", FieldFill.INSERT);
            TableFill update_time = new TableFill("gmt_modified", FieldFill.UPDATE);
            strategyConfig.setTableFillList(Arrays.asList(create_time,update_time));
        }

        //代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig);
        autoGenerator.setDataSource(dataSourceConfig);
        autoGenerator.setPackageInfo(packageConfig);
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();
    }

}
