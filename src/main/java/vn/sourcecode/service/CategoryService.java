package vn.sourcecode.service;

import org.springframework.stereotype.Service;

import vn.sourcecode.model.Category;

@Service
public class CategoryService extends BaseService<Category> {
	@Override
	public Class<Category> clazz() {
		// TODO Auto-generated method stub
		return Category.class;
	}
}
