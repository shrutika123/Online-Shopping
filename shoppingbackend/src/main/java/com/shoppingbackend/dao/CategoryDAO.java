package com.shoppingbackend.dao;

import java.util.List;

import com.shoppingbackend.dto.Category;

public interface CategoryDAO {

	
	
	
	List<Category> list();
	Category get(int id);
	
	
}
