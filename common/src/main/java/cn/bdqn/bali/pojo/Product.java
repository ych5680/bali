package cn.bdqn.bali.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6890220931649973593L;
	private Long productId;
	private ChildType childType;
	private String productName;
	private Double price;
	private String picture;
	private String information;
	private String useway;
	private Long productTypeId;
	private Set<BuyList> buyLists = new HashSet<BuyList>(0);
	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String productName, Double price, String picture) {
		this.productName = productName;
		this.price = price;
		this.picture = picture;
	}

	/** full constructor */
	public Product(ChildType childType, String productName, Double price,
			String picture, String information, String useway) {
		this.childType = childType;
		this.productName = productName;
		this.price = price;
		this.picture = picture;
		this.information = information;
		this.useway = useway;
	}
	
	public Product(Long productId, ChildType childType, String productName,
			Double price, String picture, String information, String useway,
			Set<BuyList> buyLists) {
		this.productId = productId;
		this.childType = childType;
		this.productName = productName;
		this.price = price;
		this.picture = picture;
		this.information = information;
		this.useway = useway;
		this.buyLists = buyLists;
	}

	// Property accessors

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public ChildType getChildType() {
		return this.childType;
	}

	public void setChildType(ChildType childType) {
		this.childType = childType;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getUseway() {
		return this.useway;
	}

	public void setUseway(String useway) {
		this.useway = useway;
	}

	public Set<BuyList> getBuyLists() {
		return buyLists;
	}

	public void setBuyLists(Set<BuyList> buyLists) {
		this.buyLists = buyLists;
	}

	public Long getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Long productTypeId) {
		this.productTypeId = productTypeId;
	}
}