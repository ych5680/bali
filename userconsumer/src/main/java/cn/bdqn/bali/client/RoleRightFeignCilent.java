package cn.bdqn.bali.client;

import cn.bdqn.bali.dto.Dto;
import cn.bdqn.bali.vo.RoleRightVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-provider")
@Component
public interface RoleRightFeignCilent {
    @GetMapping("/getRoleRights")
    Dto<RoleRightVo> findByRoleId(@RequestParam("roleId") Long roleId);
}
