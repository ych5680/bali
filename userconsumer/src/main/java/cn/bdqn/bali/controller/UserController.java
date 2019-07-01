package cn.bdqn.bali.controller;

import cn.bdqn.bali.client.UserFeignClient;
import cn.bdqn.bali.config.RedisUtil;
import cn.bdqn.bali.dto.Dto;
import cn.bdqn.bali.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private RedisUtil redisUtil;
    @GetMapping("/userLogin")
    public Dto<UserInfoVo> doLogin(
            @RequestParam("userName")
            String userName,
            @RequestParam("userPwd")
            String userPassword){
        System.out.println(userName+",sn:"+userPassword);
        Dto<UserInfoVo> dto = userFeignClient.doLogin(userName,userPassword);
        //如果登录成功,放入redis -- token
        if(dto.getErrorCode().equals("0000")){
            UserInfoVo userVo = dto.getData();
            //把用户放入token
            String tokenId = "TOKEN-USER-"+ UUID.randomUUID().toString().replace("-","").toUpperCase();
            System.out.println(tokenId);
            userVo.setTokenId(tokenId);
            redisUtil.set(tokenId,userVo,1800);
        }
        return dto;
    }
    @PostMapping("/checkUser")
    public Dto<UserInfoVo> checkUser(@RequestParam("userName") String userName){
        System.out.println(userName);
        return userFeignClient.checkUser(userName);
    }
    @PostMapping("/doRegister")
    public Dto<UserInfoVo> doRegister(UserInfoVo userInfoVo){
        System.out.println(userInfoVo.getUserName()+"\t"+userInfoVo.getUserPwd());
        return userFeignClient.doRegister(userInfoVo);
    }

}
