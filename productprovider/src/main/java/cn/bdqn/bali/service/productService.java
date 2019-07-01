package cn.bdqn.bali.service;

import cn.bdqn.bali.dto.Dto;
import cn.bdqn.bali.dto.DtoUtil;
import cn.bdqn.bali.mapper.ProductMapper;
import cn.bdqn.bali.pojo.BigType;
import cn.bdqn.bali.pojo.BuyList;
import cn.bdqn.bali.pojo.Product;
import cn.bdqn.bali.util.PageBean;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class productService {
    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/findBuyList")
    public Dto<BuyList> findBuyList(@RequestParam Long userId){
        List<BuyList> buyList = productMapper.findBuyList(userId);
        return DtoUtil.returnDataSuccess(buyList);
    }

    @GetMapping("/doBuy")
    public Dto<BigType> doBuy(@RequestParam Long productId,@RequestParam Long productNum,@RequestParam Long userId){
        int result = productMapper.addProductToBuyList(productId,productNum,userId);
        if (result > 0){
            return DtoUtil.returnSuccess("成功");
        }
        else {
            return DtoUtil.returnFail("失败","2333");
        }
    }

    @GetMapping("/findBigType")
    public Dto<BigType> findBigType(){
        List<BigType> bigType = productMapper.findBigType();
        return DtoUtil.returnDataSuccess(bigType);
    }

    @GetMapping("/findProductByPage")
    public Dto<Product> findProductByPage(@RequestParam int pageNo,@RequestParam Long productTypeId){
        int pageSize = 6;
        PageBean pageBean = new PageBean();
        pageBean.setPageNo(pageNo);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(productMapper.getProductTotalCount(productTypeId));
        int from = (pageBean.getPageNo()-1)*pageSize;
        RowBounds rowBounds = new RowBounds(from,pageSize);
        List findProductByPage = productMapper.findProductByPage(productTypeId,rowBounds);
        int totalPages = pageBean.getTotalPages();

        return DtoUtil.returnSuccess(String.valueOf(totalPages)+":"+pageBean.getTotalCount(),findProductByPage);
    }
}
