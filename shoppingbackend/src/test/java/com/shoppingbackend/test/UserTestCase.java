package com.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shoppingbackend.dao.UserDAO;
import com.shoppingbackend.dto.Address;
import com.shoppingbackend.dto.Cart;
import com.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;

	private static UserDAO userDAO;

	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}

/*	@Test
	public void testAdd() {

		user = new User();
		user.setFirstName("Shrutika");
		user.setLastName("Mohite");
		user.setEmail("shrutikamohite27@gmail.com");
		user.setContactNumber("8888888888");
		user.setRole("USER");
		user.setPassword("123456");

		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLineOne("G/13 sankalp siddhi building , tardeo");
		address.setAddressLineTwo("opp to navjivan socty.");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400007");
		address.setBilling(true);

		// link the user with address using user id

		address.setUserId(user.getId());

		// add the adress
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			//create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			//add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			
			//add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("navyojana sadan, grant road");
			address.setAddressLineTwo("grant road(E)");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400008");
			//set shipping to true here
			address.setShipping(true);
			
			//link it with the user
			address.setUserId(user.getId());
			
			//add the shipping address
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
			}
	} */
	
	/*@Test
	public void testAdd() {

		user = new User();
		user.setFirstName("Shrutika");
		user.setLastName("Mohite");
		user.setEmail("shrutikamohite27@gmail.com");
		user.setContactNumber("8888888888");
		user.setRole("USER");
		user.setPassword("123456");
	
		if(user.getRole().equals("USER")) {
			//create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			
			//attach cart with the user
			user.setCart(cart);
			}
			
		// add the user
				assertEquals("Failed to add user!", true, userDAO.addUser(user));

			}*/
	/*@Test
	public void testUpdateCart() {
	
	//fetch the user by its email
	user = userDAO.getByEmail("shrutikamohite27@gmail.com");
	
	//get the cart of the user
	cart = user.getCart();
	
	
	cart.setGrandTotal(5555);
	cart.setCartLines(2);
	
	assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
	}*/
	
	
	/*@Test
	public void testAddress() {
	
		//we need to add an user
		
		user = new User();
		user.setFirstName("Shrutika");
		user.setLastName("Mohite");
		user.setEmail("shrutikamohite27@gmail.com");
		user.setContactNumber("8888888888");
		user.setRole("USER");
		user.setPassword("123456");

		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
		
		
		
		//we are going to add the address
		
		address = new Address();
		address.setAddressLineOne("G/13 sankalp siddhi building , tardeo");
		address.setAddressLineTwo("opp to navjivan socty.");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400007");
		address.setBilling(true);
		
		//attach the user to the address
		address.setUser(user);
		
		assertEquals("Failed to add an address!", true, userDAO.addAddress(address));

		
		
		//we are also going to add the shipping address
		
		address = new Address();
		address.setAddressLineOne("navyojana sadan, grant road");
		address.setAddressLineTwo("grant road(E)");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400008");
		//set shipping to true here
		address.setShipping(true);

		//attach the user to the address
				address.setUser(user);
				
				assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
		
	}*/
	
	/*@Test
	public void testAddAdress() {
		
		user = userDAO.getByEmail("shrutikamohite27@gmail.com");
	
		//we are also going to add the shipping address
		
				address = new Address();
				address.setAddressLineOne("navyojana sadan, grant road");
				address.setAddressLineTwo("grant road(W)");
				address.setCity("pune");
				address.setState("Maharashtra");
				address.setCountry("India");
				address.setPostalCode("400008");
				//set shipping to true here
				address.setShipping(true);

				//attach the user to the address
						address.setUser(user);
						
						assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
	}*/
	@Test
	public void testGetAddress() {
		
		user = userDAO.getByEmail("shrutikamohite27@gmail.com");
		
		assertEquals("Failes to fetch the list of address and size does not match!",3, 
				userDAO.listShippingAddress(user).size());

		
		assertEquals("Failes to fetch the billing address and size does not match!","Mumbai",
				userDAO.getBillingAddress(user).getCity());
		
		
		
	}
	
	
	}


