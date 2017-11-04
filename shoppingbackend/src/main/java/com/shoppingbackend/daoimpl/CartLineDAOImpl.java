package com.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingbackend.dao.CartLineDAO;
import com.shoppingbackend.dto.Cart;
import com.shoppingbackend.dto.CartLine;

@Repository
@Transactional
public class CartLineDAOImpl implements CartLineDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public CartLine get(int id) {
		return sessionFactory.getCurrentSession().get(CartLine.class, id);
	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(CartLine cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletet(CartLine cartLine) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CartLine> list(int cartId) {
		String query = "FROM cartLine WHERE cartId = :cartId";
		return sessionFactory.getCurrentSession()
							.createQuery(query, CartLine.class)
							.setParameter("cartId", cartId)
							.getResultList();
		
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query = "FROM cartLine WHERE cartId = :cartId AND available = :available";
		return sessionFactory.getCurrentSession()
							.createQuery(query, CartLine.class)
							.setParameter("cartId", cartId)
							.setParameter("available", true)
							.getResultList();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query = "FROM cartLine WHERE cartId = :cartId AND poduct.id = :productId";
		try {
		return sessionFactory.getCurrentSession()
							.createQuery(query, CartLine.class)
							.setParameter("cartId", cartId)
							.setParameter("productId", productId)
							.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}

	}
	//related to the cart
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
