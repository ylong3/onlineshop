package cn.landsall.switchapi.mapper;

import cn.landsall.switchapi.entity.BagInfo;
import cn.landsall.switchapi.entity.model.Bag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ylong
 * @since 2021-06-18
 */
public interface BagInfoMapper extends BaseMapper<BagInfo> {
     List<Bag> SelectBagInfoListByUserId(Long userId,boolean filterSelect);
}
