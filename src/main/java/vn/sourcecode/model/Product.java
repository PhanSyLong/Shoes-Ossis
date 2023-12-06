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
@Table(name = "tbl_product")
public class Product extends BaseModel {
	@Column(name = "name", length = 300, nullable = false)
	private String name;

	@Column(name = "avatar", length = 300, nullable = true)
	private String avatar;

	@Column(name = "price", nullable = true)
	private BigDecimal price;

	@Column(name = "sale_price", nullable = true)
	private BigDecimal salePrice;

	@Column(name = "short_description", length = 500, nullable = true)
	private String shortDescription;

	@Column(name = "detail_description", nullable = true)
	private String detailDescription;

	@Column(name = "is_hot", nullable = true)
	private Boolean isHot = Boolean.FALSE;

	@Column(name = "seo", length = 1000, nullable = true)
	private String seo;
	
	//-----------------------------------------tbl_Product-to-tbl_User(Create_by and Update_by)--------------------------------------------
	//---------------Mapping many-to-one: product-create_by-user----------------------------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name =	"create_by")
		private User userCreateProduct;
		public User getUserCreateProduct() {
			return userCreateProduct;
		}
		
		public void setUserCreateProduct(User userCreateProduct) {
			this.userCreateProduct = userCreateProduct;
		}
	//---------------Mapping many-to-one: product-update_by-user----------------------------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name =	"update_by")
		private User userUpdateProduct;
		public User getUserUpdateProduct() {
			return userUpdateProduct;
		}

		public void setUserUpdateProduct(User userUpdateProduct) {
			this.userUpdateProduct = userUpdateProduct;
		}
	//-------------------------------------------------------------------------------------------------------------------------------------
		// --------------Mapping many-to-one: product-to-category------------------------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "category_id")
		private Category category;

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}
	//-------------------------------------------------------------------------------------

	// --------------Mapping one-to-many: tbl_product-to-tbl_product_img-------------------
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
		private Set<ProductImages> productImages = new HashSet<ProductImages>();

		// Methods add and remove Elements in relational product list
		public void addRelationalProductImage(ProductImages productimage) {
			productImages.add(productimage);
			productimage.setProduct(this);
		}

		public void removeRelationalProductImage(ProductImages productimage) {
			productImages.remove(productimage);
			productimage.setProduct(null);
		}
	//--------------------------------------------------------------------------------------
		
	// --------------Mapping one-to-many: tbl_product-to-tbl_sale_order_product--------------
		@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
		private Set<SaleOrderProduct> saleorderproducts = new HashSet<SaleOrderProduct>();
		
		//Methods add and remove Elements in relational product list
		public void addRelationalProduct(SaleOrderProduct saleorderproduct) {
			saleorderproducts.add(saleorderproduct);
			saleorderproduct.setProduct(this);
		}
		public void removeRelationalProduct(SaleOrderProduct saleorderproduct) {
			saleorderproducts.remove(saleorderproduct);
			saleorderproduct.setProduct(null);
		}
	//---------------------------------------------------------------------------------------

	public Product() {
		super();
	}

	public Product(String name, String avatar, BigDecimal price, BigDecimal salePrice, String shortDescription,
			String detailDescription, Boolean isHot, String seo) {
		super();
		this.name = name;
		this.avatar = avatar;
		this.price = price;
		this.salePrice = salePrice;
		this.shortDescription = shortDescription;
		this.detailDescription = detailDescription;
		this.isHot = isHot;
		this.seo = seo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	public Boolean getIsHot() {
		return isHot;
	}

	public void setIsHot(Boolean isHot) {
		this.isHot = isHot;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}
	
	
}
