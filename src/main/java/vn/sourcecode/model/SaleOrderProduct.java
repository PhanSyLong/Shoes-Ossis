package vn.sourcecode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_sale_order_product")
public class SaleOrderProduct extends BaseModel {
	
	@Column(name = "quantity", nullable = true)
	private Integer quantity;

	@Column(name = "description", length = 500, nullable = true)
	private String description;
	
	// --------------Mapping many-to-one: tbl_sale_order_product-to-tbl_sale_order---------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "sale_order_id")
		private SaleOrder saleorder;
		

		public SaleOrder getSaleorder() {
			return saleorder;
		}


		public void setSaleorder(SaleOrder saleorder) {
			this.saleorder = saleorder;
		}

		// --------------Mapping many-to-one: tbl_sale_order_product-to-tbl_product---------------
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "product_id")
		private Product product;
		
		public Product getProduct() {
			return product;
		}


		public void setProduct(Product product) {
			this.product = product;
		}


		public SaleOrderProduct() {
			super();
		}


		public SaleOrderProduct(Integer quantity, String description, SaleOrder saleorder, Product product) {
			super();
			this.quantity = quantity;
			this.description = description;
			this.saleorder = saleorder;
			this.product = product;
		}


		public Integer getQuantity() {
			return quantity;
		}


		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}
		
		
}
