package vn.sourcecode.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_sale_order")
public class SaleOrder extends BaseModel {

	@Column(name = "code", length = 60, nullable = false)
	private String code;

	@Column(name = "total", nullable = true)
	private BigDecimal total;

	@Column(name = "customer_name", length = 300, nullable = false)
	private String customerName;

	@Column(name = "customer_mobile", length = 120, nullable = false)
	private String customerMobile;

	@Column(name = "customer_email", length = 120, nullable = false)
	private String customerEmail;

	@Column(name = "customer_address", length = 300, nullable = false)
	private String customerAddress;

	// ---------------Many-to-One: tbl_sale_order-to-tbl_user----------------
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User users;

	public User getUser() {
		return users;
	}

	public void setUser(User user) {
		this.users = user;
	}

	// --------------Mapping one-to-many:
	// tbl_sale_order-to-tbl_sale_order_product---------------
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "saleorder")
	private Set<SaleOrderProduct> saleorderproducts = new HashSet<SaleOrderProduct>();

	public Set<SaleOrderProduct> getSaleorderproducts() {
		return saleorderproducts;
	}

	public void setSaleorderproducts(Set<SaleOrderProduct> saleorderproducts) {
		this.saleorderproducts = saleorderproducts;
	}

	// Methods add and remove Elements in relational product list
	public void addRelationalProduct(SaleOrderProduct saleorderproduct) {
		saleorderproducts.add(saleorderproduct);
		saleorderproduct.setSaleorder(this);
	}

	public void removeRelationalProduct(SaleOrderProduct saleorderproduct) {
		saleorderproducts.remove(saleorderproduct);
		saleorderproduct.setSaleorder(null);
	}
	// ---------------------------------------------------------------------------------------------

	public SaleOrder() {
		super();
	}

	public SaleOrder(String code, BigDecimal total, String customerName, String customerMobile, String customerEmail,
			String customerAddress, User users, Set<SaleOrderProduct> saleorderproducts) {
		super();
		this.code = code;
		this.total = total;
		this.customerName = customerName;
		this.customerMobile = customerMobile;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.users = users;
		this.saleorderproducts = saleorderproducts;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}
	
	
}
