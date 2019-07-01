package cn.bdqn.bali.controller;

import cn.bdqn.bali.client.RoleRightFeignCilent;
import cn.bdqn.bali.dto.Dto;
import cn.bdqn.bali.pojo.RoleRight;
import cn.bdqn.bali.vo.RoleRightVo;
import cn.bdqn.bali.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RoleRightController {
    @Autowired
    private RoleRightFeignCilent roleRightFeignCilent;

    @GetMapping("/getRoleRights")
    public Dto<RoleRightVo> findByRoleId(@RequestParam("roleId")
                                                     Long roleId){

        return roleRightFeignCilent.findByRoleId(roleId);
    }
}
