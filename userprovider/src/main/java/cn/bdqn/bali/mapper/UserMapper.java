package cn.bdqn.bali.mapper;

import cn.bdqn.bali.pojo.UserInfo;
import cn.bdqn.bali.vo.UserInfoVo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
@Component
public interface UserMapper {
    List<UserInfo> getUserListByMap(Map<String, Object> userMap);

    int insertUserInfoByEntity(UserInfo userInfo);
}
