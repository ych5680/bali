package cn.bdqn.bali.pojo;


/**
 * �ѹ��� entity
 */

public class BuyList implements java.io.Serializable {

    // Fields    

	private static final long serialVersionUID = -6532693625945261683L;
	private Long buyListId;
     private UserInfo userInfo;
     private Product product;
     private Long productNum;


    // Constructors

    /** default constructor */
    public BuyList() {
    }

    
    /** full constructor */
    public BuyList(UserInfo userInfo, Product product, Long productNum) {
        this.userInfo = userInfo;
        this.product = product;
        this.productNum = productNum;
    }

   
    // Property accessors

    public Long getBuyListId() {
        return this.buyListId;
    }
    
    public void setBuyListId(Long buyListId) {
        this.buyListId = buyListId;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }
    
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getProductNum() {
        return this.productNum;
    }
    
    public void setProductNum(Long productNum) {
        this.productNum = productNum;
    }
   


}