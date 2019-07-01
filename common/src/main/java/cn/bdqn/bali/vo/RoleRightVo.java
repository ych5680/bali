package cn.bdqn.bali.vo;

import cn.bdqn.bali.pojo.SysRight;

import java.io.Serializable;
import java.util.List;

public class RoleRightVo implements Serializable {

    private Long roleId; //角色id
    //private String roleName; //角色名称
    private List<SysRight> rightList; //角色对应的权限集合

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<SysRight> getRightList() {
        return rightList;
    }

    public void setRightList(List<SysRight> rightList) {
        this.rightList = rightList;
    }
}
