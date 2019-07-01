package cn.bdqn.bali.client;

import cn.bdqn.bali.dto.Dto;
import cn.bdqn.bali.pojo.BigType;
import cn.bdqn.bali.pojo.BuyList;
import cn.bdqn.bali.pojo.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "product-provider")
public interface ProductFeignClient {
    @GetMapping("/findBigType")
    Dto findBigType();
    @GetMapping("/findProductByPage")
    Dto findProductByPage(@RequestParam("pageNo") int pageNo, @RequestParam("productTypeId") Long productTypeId);
    @GetMapping("/findBuyList")
    Dto findBuyList(@RequestParam("userId")Long userId);
    @GetMapping("/doBuy")
    Dto doBuy(@RequestParam("productId")Long productId, @RequestParam("productNum")Long productNum, @RequestParam("userId")Long userId);
}
