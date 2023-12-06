package vn.sourcecode.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import vn.sourcecode.dto.JwConstants;
import vn.sourcecode.dto.SearchModel;
import vn.sourcecode.model.Product;
import vn.sourcecode.model.ProductImages;

@Service
public class ProductService extends BaseService<Product> implements JwConstants {
	@Override
	public Class<Product> clazz() {
		// TODO Auto-generated method stub
		return Product.class;
	}
	
	public List<Product> findAllActive() {
		// TODO Auto-generated method stub
		return super.executeNativeSql("SELECT * FROM  tbl_product WHERE status=1");
	}

	// Ham kiem tra file co duoc upload khong
	public boolean isUploadFile(MultipartFile file) {
		if (file == null || file.getOriginalFilename().isEmpty()) {
			return false; // Khong upload
		}
		return true; // co upload
	}

	// Ham kiem tra danh sach file co upload file nao khong
	public boolean isUploadFiles(MultipartFile[] files) {
		if (files == null || files.length == 0) {
			return false; // Khong upload
		}
		return true; // co upload
	}
	//--------------------Save new product---------------------------------------------------------------------
		@Transactional
		public Product saveAddProduct( Product product,
									MultipartFile avatarFile,
									MultipartFile[] imageFiles) throws IOException {
			// Luu avatar file 
			if (isUploadFile(avatarFile)){ // co file upload
				// Luu file vao thu muc Product/Avatar
				String path = FOLDER_UPLOAD + "Product/Avatar/" + avatarFile.getOriginalFilename();
				File file = new File(path);
				avatarFile.transferTo(file);
				product.setAvatar("Product/Avatar/" + avatarFile.getOriginalFilename());
			}	
			// Luu images file
			if(isUploadFiles(imageFiles)) { //Co upload danh sach image
				// Duyet danh sach file image
				for(MultipartFile imageFile : imageFiles) {
					if (isUploadFile(imageFile)) {
						// Luu file vao thu muc Product/Image/
						String path = FOLDER_UPLOAD + "Product/Image/" + imageFile.getOriginalFilename();
						File file = new File(path);
						imageFile.transferTo(file);
						//Luu duong dan vao tbl_product_image
						ProductImages productImages = new ProductImages();
						productImages.setTitle(imageFile.getOriginalFilename());
						productImages.setPath("Product/Image/" + imageFile.getOriginalFilename());
						productImages.setStatus(Boolean.TRUE);
						productImages.setCreateDate(new Date());
						product.addRelationalProductImage(productImages);// Luu sang bang tbl_product_image
					}
				}
			}
			return super.saveOrUpdate(product);
		}
		
	//--------------------Save edit product------------------------------------------------------------------
		@Transactional
		public Product saveEditProduct( Product product,
				MultipartFile avatarFile,
				MultipartFile[] imageFiles) throws IOException {
			//Lay product trong DB
			Product dbProduct = super.getById(product.getId());
			// Luu file avatar moi neu nguoi dung co upload them avatar
			if (isUploadFile(avatarFile)){ // co file upload
				//Xoa avatar cu
				String path = FOLDER_UPLOAD + dbProduct.getAvatar();
				File file = new File(path);
				file.delete();
				
				// Luu file avatar moi vao thu muc Product/Avatar
				 path = FOLDER_UPLOAD + "Product/Avatar/" + avatarFile.getOriginalFilename();
				file = new File(path);
				avatarFile.transferTo(file);
				//Luu duong dan cua avatar moi vao bang tbl_product
				product.setAvatar("Product/Avatar/" + avatarFile.getOriginalFilename());
			}
			else { // nguoi dung khong upload avatar file
				//Giu nguyen avatar cu
				product.setAvatar(dbProduct.getAvatar());
			}
			// Luu images file
			if(isUploadFiles(imageFiles)) { //Co upload danh sach image
				// Duyet danh sach file image
				for(MultipartFile imageFile : imageFiles) {
					if (isUploadFile(imageFile)) {
						// Luu file vao thu muc Product/Image/
						String path = FOLDER_UPLOAD + "Product/Image/" + imageFile.getOriginalFilename();
						File file = new File(path);
						imageFile.transferTo(file);
						//Luu duong dan vao tbl_product_image
						ProductImages productImages = new ProductImages();
						productImages.setTitle(imageFile.getOriginalFilename());
						productImages.setPath("Product/Image/" + imageFile.getOriginalFilename());
						productImages.setStatus(Boolean.TRUE);
						productImages.setCreateDate(new Date());
						//Luu (doi tuong product image) duong dan anh sang bang tbl_product_image
						product.addRelationalProductImage(productImages);// 
					}
				}
			}
			return super.saveOrUpdate(product);
		}
		@Autowired 
		private ProductImageService productImageService;
		
		//---------------------Delete product------------------------------------------------
		@Transactional
		public void deleteProductById(int productId) {
			//Lay product trong DB
			Product product = super.getById(productId);
			
			//+Lay danh sahc anh cua product trong tbl_product_image
			String sql = "SELECT * FROM tbl_product_image where product_id=" + productId;
			List<ProductImages> productImages = productImageService.executeNativeSql(sql);
			
			//Xoa lan luot cac anh cua product trong Product/image va
			//Xoa lan luot cac duong dan anh trong tbl_product_image
			for(ProductImages productImage : productImages) {
				
			//Xoa file trong thu muc image truoc
			String path = FOLDER_UPLOAD + productImage.getPath();
			File file = new File(path);
			file.delete();
			//Xoa thong tin anh trong tbl_product_image
//			product.removeRelationalProductImage(productImage); //restrict
		}
			//Xoa file avatar trong thu muc Product/Avatar
			String path = FOLDER_UPLOAD + product.getAvatar();
			File file = new File(path);
			file.delete();
			
			//Xoa product trong db
			super.deleteById(productId);
		}
		
	//-------------------------Search product-----------------------------------------
		public List<Product> searchProduct( SearchModel productSearch) {
			//tao cau lenh truy van
			String sql = "SELECT * FROM tbl_product p WHERE 1=1";
			
			//Tim kiem voi status
			if (productSearch.getStatus() !=2) {//Co chon Active/Inactive
				sql += " AND p.status=" + productSearch.getStatus();
			}
			
			//Tim kiem voi category
			if (productSearch.getCategoryId() !=0) {
				sql += " AND p.category_id=" + productSearch.getCategoryId();
			}
			
			//Tim kiem voi keyword
			
			if(!StringUtils.isEmpty(productSearch.getKeyword())) {
				
				String keyword = productSearch.getKeyword().toLowerCase();
				sql += 	" AND (LOWER(p.name) like '%" + keyword + "%'" +
						" OR LOWER(p.short_description) like '%" + keyword + "%'" +
						" OR LOWER(p.seo) like '%" + keyword + "%')";
			}
			
			if(!StringUtils.isEmpty(productSearch.getBeginDate()) && 
					!StringUtils.isEmpty(productSearch.getEndDate())){
				
				String beginDate = productSearch.getBeginDate();
				String endDate = productSearch.getEndDate();
				
				sql += " AND p.create_date BETWEEN '" + beginDate + "' AND '" + endDate + "'";
			}
			return super.executeNativeSql(sql);
		}
}
