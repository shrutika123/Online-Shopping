package com.shoppingbackend.dao;

import java.util.List;

import com.shoppingbackend.dto.Address;
import com.shoppingbackend.dto.Cart;
import com.shoppingbackend.dto.User;

public interface UserDAO {

	//add an user
	boolean addUser(User user);
	User getByEmail(String email);
	
	
	//add an address
	boolean addAddress(Address address);
	//alternative
	//Address getBillingAddress(int userId);
	//List<Address> listShippingAddress(int userId);

	
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	//update a cart
	boolean updateCart(Cart cart);
}
