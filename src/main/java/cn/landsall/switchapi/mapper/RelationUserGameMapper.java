package cn.landsall.switchapi.mapper;

import cn.landsall.switchapi.entity.RelationUserGame;
import cn.landsall.switchapi.entity.model.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ylong
 * @since 2021-06-17
 */
public interface RelationUserGameMapper extends BaseMapper<RelationUserGame> {
public List<Collect> SelectCollectByUserId(Long userId);
}
