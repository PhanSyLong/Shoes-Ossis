package vn.sourcecode.service;

import org.springframework.stereotype.Service;

import vn.sourcecode.model.ProductImages;

@Service
public class ProductImageService extends BaseService<ProductImages> {
	@Override
	public Class<ProductImages> clazz() {
		// TODO Auto-generated method stub
		return ProductImages.class;
	}
}
