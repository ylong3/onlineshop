package cn.landsall.switchapi.service.impl;

import cn.landsall.switchapi.entity.RelationUserGame;
import cn.landsall.switchapi.entity.model.Collect;
import cn.landsall.switchapi.mapper.RelationUserGameMapper;
import cn.landsall.switchapi.service.IRelationUserGameService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ylong
 * @since 2021-06-17
 */
@Service
public class RelationUserGameServiceImpl extends ServiceImpl<RelationUserGameMapper, RelationUserGame> implements IRelationUserGameService {
    public List<Collect> SelectCollectByUserId(Long userId){
        return baseMapper.SelectCollectByUserId(userId);
    }
}
