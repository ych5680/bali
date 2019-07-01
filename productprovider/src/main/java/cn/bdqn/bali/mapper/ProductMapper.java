package cn.bdqn.bali.mapper;

import cn.bdqn.bali.pojo.BuyList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ProductMapper {
    List findBigType();

    int getProductTotalCount(@Param("productTypeId")Long productTypeId);

    List findProductByPage(@Param("productTypeId")Long productTypeId, RowBounds rowBounds);

    int addProductToBuyList(@Param("productId") Long productId, @Param("productNum") Long productNum, @Param("UserId") Long UserId);

    List<BuyList> findBuyList(@Param("userId") Long userId);
}
