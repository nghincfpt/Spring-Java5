package edu.poly.shop.service;

import java.util.Collection;

import edu.poly.shop.model.CartItem;

public interface ShoppingCartService {

	int getCount();

	double getAmount();

	void update(int productid, int quantity);

	void clear();

	Collection<CartItem> getCartltems();

	void remove(long productId);

	void add(CartItem item);

}
