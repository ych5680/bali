package cn.bdqn.bali.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * ChildType entity. @author MyEclipse Persistence Tools
 */

public class ChildType implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6813277454161187904L;
	private Long childTypeId;
	private BigType bigType;
	private String childName;
	private Set<Product> products = new HashSet<Product>();//��Ӧ��Ʒ

	// Constructors

	/** default constructor */
	public ChildType() {
	}

	/** minimal constructor */
	public ChildType(String childName) {
		this.childName = childName;
	}

	/** full constructor */
	public ChildType(BigType bigType, String childName, Set<Product> products) {
		this.bigType = bigType;
		this.childName = childName;
		this.products = products;
	}

	// Property accessors

	public Long getChildTypeId() {
		return this.childTypeId;
	}

	public void setChildTypeId(Long childTypeId) {
		this.childTypeId = childTypeId;
	}

	public BigType getBigType() {
		return this.bigType;
	}

	public void setBigType(BigType bigType) {
		this.bigType = bigType;
	}

	public String getChildName() {
		return this.childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}