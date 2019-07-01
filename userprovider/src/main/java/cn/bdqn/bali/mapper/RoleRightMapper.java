package cn.bdqn.bali.mapper;

import cn.bdqn.bali.pojo.RoleRight;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleRightMapper {
    List<RoleRight> getRoleRightListByRoleId(Long roleId);
}
