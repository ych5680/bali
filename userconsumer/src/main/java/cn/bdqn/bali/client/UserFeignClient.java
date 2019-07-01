package cn.bdqn.bali.client;

import cn.bdqn.bali.dto.Dto;
import cn.bdqn.bali.vo.UserInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-provider")
public interface UserFeignClient {

    @GetMapping("/doLogin")
    Dto<UserInfoVo> doLogin(
            @RequestParam("userName")
                    String userName,
            @RequestParam("userPwd")
                    String userPassword);
    @GetMapping("/checkUser")
    Dto<UserInfoVo> checkUser(@RequestParam("userName")String userName);
    @PostMapping("/doRegister")
    Dto<UserInfoVo> doRegister(@RequestBody UserInfoVo userInfoVo);
}
