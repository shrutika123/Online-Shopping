package com.shopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.shopping.model.RegisterModel;
import com.shoppingbackend.dao.UserDAO;
import com.shoppingbackend.dto.Address;
import com.shoppingbackend.dto.Cart;
import com.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	
	
	@Autowired 
	private UserDAO userDAO;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public RegisterModel init() {
		
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String validateUser(User user, MessageContext error) {
		
		String transitionValue = "success";
		
		//checking password 
		if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			
			error.addMessage(new MessageBuilder()
											.error()
											.source("confirmPassword")
											.defaultText("Password does not match")
											.build());
			
			transitionValue = "failure";
		}
		
		//check uniqueness of the email id
		if(userDAO.getByEmail(user.getEmail())!=null) {
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("Email id already exist!")
					.build()
										
					);
			
			transitionValue = "failure";
			
			
		}
		
		
		return transitionValue;
	}
	
	
	public String saveall(RegisterModel model) {
		String transitionValue = "success";
		
		//fetch the user
		
		User user = model.getUser();
		if(user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//encode the password
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		
		//save the user
		
		userDAO.addUser(user);
		
		//get the address
		Address billing = model.getBilling();
		//address.java change 
		billing.setUserId(user.getId());
		billing.setBilling(true);
		
		//save the address
		userDAO.addAddress(billing);
		
		return transitionValue;
	}
}
