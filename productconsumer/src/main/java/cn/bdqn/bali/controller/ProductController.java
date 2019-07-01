package cn.bdqn.bali.controller;


import cn.bdqn.bali.client.*;
import cn.bdqn.bali.dto.Dto;
import cn.bdqn.bali.dto.DtoUtil;
import cn.bdqn.bali.pojo.BigType;
import cn.bdqn.bali.pojo.BuyList;
import cn.bdqn.bali.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductFeignClient productFeignClient;

    @GetMapping("/findBuyList")
    public Dto<BuyList> findBuyList(@RequestParam Long userId){
        return productFeignClient.findBuyList(userId);
    }
    @GetMapping("/doBuy")
    public Dto<BigType> doBuy(@RequestParam Long productId,@RequestParam Long productNum,@RequestParam Long userId) {
        return productFeignClient.doBuy(productId,productNum,userId);
    }
        @GetMapping("/findBigType")
    public Dto<BigType> findBigType(){
        return productFeignClient.findBigType();
    }

    @GetMapping("/findProductByPage")
    public Dto<Product> findProductByPage(@RequestParam("pageNo") int pageNo, @RequestParam("productTypeId") Long productTypeId){
        return productFeignClient.findProductByPage(pageNo,productTypeId);
    }
}
