package cn.bdqn.bali.service;

import cn.bdqn.bali.dto.Dto;
import cn.bdqn.bali.dto.DtoUtil;
import cn.bdqn.bali.mapper.UserMapper;
import cn.bdqn.bali.pojo.UserInfo;
import cn.bdqn.bali.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/doLogin")
    public Dto<UserInfoVo> doLogin(@RequestParam String userName
                                    ,@RequestParam String userPwd){
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("userName",userName);
        userMap.put("userPwd",userPwd);
        List<UserInfo> userInfoVoList =  userMapper.getUserListByMap(userMap);
        if (userInfoVoList.size()>0){
            UserInfo userInfo = userInfoVoList.get(0);
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setUserName(userInfo.getUserName());
            userInfoVo.setUserPwd(userInfo.getUserPwd());
            userInfoVo.setUserRoleId(userInfo.getUserRoleId());
            userInfoVo.setUserId(userInfo.getUserId());
            return DtoUtil.returnSuccess("登陆成功",userInfoVo);
        }else {
            return DtoUtil.returnFail("登陆失败","0001");
        }
    }
    @GetMapping("/checkUser")
    Dto<UserInfoVo> checkUser(@RequestParam("userName")String userName){
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("userName",userName);
        List<UserInfo> userInfoVoList= userMapper.getUserListByMap(userMap);
        if (userInfoVoList.size()>0) {
            return DtoUtil.returnSuccess("input");
        }else {
            return DtoUtil.returnSuccess("success");
        }
    }
    @PostMapping("/doRegister")
    Dto<UserInfoVo> doRegister(@RequestBody UserInfoVo userInfoVo){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userInfoVo.getUserName());
        userInfo.setUserPwd(userInfoVo.getUserPwd());
        userInfo.setUserRoleId(userInfoVo.getUserRoleId());
        System.out.println(userInfoVo.getUserName());
        int result = userMapper.insertUserInfoByEntity(userInfo);
        if (result > 0){
            return DtoUtil.returnSuccess("success");
        }else{
            return DtoUtil.returnSuccess("error");
        }
    }
}
