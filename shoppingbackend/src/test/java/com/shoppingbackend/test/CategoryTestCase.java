package com.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shoppingbackend.dao.CategoryDAO;
import com.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category();
	 * 
	 * category.setName("Mobile");
	 * category.setDescription("This is the description of Mobile");
	 * category.setImgURL("CAT_3.png");
	 * 
	 * assertEquals("successfully added category inside the table!",true,
	 * categoryDAO. add(category)); }
	 */

	/*
	 * @Test public void testGetCategory() { category = categoryDAO.get(3);
	 * 
	 * assertEquals("successfully fetched a single  category from the table!"
	 * ,"Mobile",category.getName());
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test public void testUpdateCategory() { category = categoryDAO.get(3);
	 * 
	 * category.setName("mob");
	 * 
	 * assertEquals("successfully updated a single  category in the table!", true,
	 * categoryDAO.update(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testDeleteCategory() { category = categoryDAO.get(3);
	 * assertEquals("successfully deleted a single  category in the table!", true,
	 * categoryDAO.delete(category));
	 * 
	 * }
	 */

	/*
	 * @Test public void testListCategory() {
	 * 
	 * assertEquals("Successfully fetched the list of categories from the table!",2,
	 * categoryDAO.list().size()); }
	 */

	@Test
	public void testCRUDCategory() {
		// add operation
		category = new Category();

		category.setName("Mobile");
		category.setDescription("This is the description of Mobile");
		category.setImgURL("CAT_1.png");

		assertEquals("successfully added category inside the table!", true, categoryDAO.add(category));

		category = new Category();

		category.setName("Television");
		category.setDescription("This is the description of Television");
		category.setImgURL("CAT_1.png");

		assertEquals("successfully added category inside the table!", true, categoryDAO.add(category));

		// fetching and updating the category
		category = categoryDAO.get(1);

		category.setName("mob");

		assertEquals("successfully updated a single  category in the table!", true, categoryDAO.update(category));

		// delete the category
		assertEquals("successfully deleted a single  category in the table!", true, categoryDAO.delete(category));

		//fetching the list
		assertEquals("Successfully fetched the list of categories from the table!", 2, categoryDAO.list().size());

	}

}
