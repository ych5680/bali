package cn.bdqn.bali.vo;

public class BuyListVo {
    private String childName;
    private String productName;
    private Double price;
    private int productNum;

    public BuyListVo(String childName, String productName, Double price, int productNum) {
        this.childName = childName;
        this.productName = productName;
        this.price = price;
        this.productNum = productNum;
    }

    public BuyListVo() {
    }

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getProductNum() {
        return productNum;
    }

    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }
}
