package cn.bdqn.bali.service;

import cn.bdqn.bali.dto.Dto;
import cn.bdqn.bali.dto.DtoUtil;
import cn.bdqn.bali.mapper.RoleRightMapper;
import cn.bdqn.bali.pojo.RoleRight;
import cn.bdqn.bali.pojo.SysRight;
import cn.bdqn.bali.vo.RoleRightVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoleRightService {
    @Autowired
    private RoleRightMapper roleRightMapper;

    @GetMapping("/getRoleRights")
    public Dto<RoleRightVo> findByRoleId(
            @RequestParam("roleId")
                    Long roleId){
        List<RoleRight> roleList = roleRightMapper.getRoleRightListByRoleId(roleId);
        List<SysRight> rightList = new ArrayList<>();
        for (RoleRight roleRight:roleList) {
            rightList.add(roleRight.getSysRight());
        }
        RoleRightVo roleRightVo = new RoleRightVo();
        roleRightVo.setRoleId(roleId);
        roleRightVo.setRightList(rightList);

        return DtoUtil.returnSuccess("成功",roleRightVo);


    }
}
