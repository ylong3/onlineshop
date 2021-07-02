package cn.landsall.switchapi.service.impl;

import cn.landsall.switchapi.entity.UserInfo;
import cn.landsall.switchapi.mapper.UserInfoMapper;
import cn.landsall.switchapi.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ylong
 * @since 2021-06-19
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
