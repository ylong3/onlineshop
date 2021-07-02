package cn.landsall.switchapi.service.impl;

import cn.landsall.switchapi.common.SnowflakeIdWorker;
import cn.landsall.switchapi.entity.BagInfo;
import cn.landsall.switchapi.entity.model.Bag;
import cn.landsall.switchapi.mapper.BagInfoMapper;
import cn.landsall.switchapi.service.IBagInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ylong
 * @since 2021-06-18
 */
@Service
public class BagInfoServiceImpl extends ServiceImpl<BagInfoMapper, BagInfo> implements IBagInfoService {


    public void insertOne(BagInfo bagInfo){
        bagInfo.setCount(1);
        baseMapper.insert(bagInfo);
    }

    public List<Bag> listByUserId(Long userId,Boolean filterSelect){
        return baseMapper.SelectBagInfoListByUserId(userId,filterSelect);
    }

}
