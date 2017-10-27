package com.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shoppingbackend.dao.ProductDAO;
import com.shoppingbackend.dto.Product;

public class ProductTestCase {

	private static AnnotationConfigApplicationContext context;

	private static ProductDAO productDAO;

	private Product product;
	

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO)context.getBean("productDAO");
	}

	/*
	 * @Test public void testCRUDProduct() { // add operation product = new
	 * Product();
	 * 
	 * product.setName("Oppo f1"); product.setBrand("Oppo");
	 * product.setDescription("this phone also called as selfee phone");
	 * product.setUnitPrice(25000); product.setQuantity(5); product.setActive(true);
	 * product.setCategoryId(1); product.setSupplierId(2);
	 * assertEquals("Something went wrong while inseting a new product!", true,
	 * productDAO.add(product));
	 * 
	 * 
	 * // fetching and updating the category product = productDAO.get(2);
	 * 
	 * product.setName("iphone 5c");
	 * 
	 * assertEquals("Something went wrong while updating existing record!", true,
	 * productDAO.update(product));
	 * 
	 * // delete the category
	 * assertEquals("Something went wrong while deleting existing record!", true,
	 * productDAO.delete(product));
	 * 
	 * //fetching the list
	 * assertEquals("Something went wrong while fetching the list of products!", 5,
	 * productDAO.list().size());
	 * 
	 * }
	 */

	@Test
	public void testListActiveProducts() {

		assertEquals("Successfully fetched the list of categories from the table!", 5, productDAO.listActiveProducts().size());
	}

	@Test
	public void testListActiveProductsByCategory() {

		assertEquals("Something went wrong while fetching the list of products!", 5, productDAO.listActiveProductsByCategory(1).size());
	}

	@Test
	public void testGetLatestActiveProducts() {

		assertEquals("Something went wrong while fetching the list of products!", 5, productDAO.getLatestActiveProducts(5).size());
	}
	


}
