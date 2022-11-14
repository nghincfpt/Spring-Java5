package edu.poly.shop.service.Impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import edu.poly.shop.model.CartItem;
import edu.poly.shop.service.ShoppingCartService;

@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService {

	private Map<Long, CartItem> map = new HashMap<Long, CartItem>();

	@Override
	public void add(CartItem item) {
		CartItem existedItem = map.get(item.getProductId());
		if (existedItem != null) {
			existedItem.setQuantity(item.getQuantity() + existedItem.getQuantity());
		} else {
			map.put(item.getProductId(), item);
		}

	}

	@Override
	public void remove(long productid) {
		map.remove(productid);
	}

	@Override
	public Collection<CartItem> getCartltems() {
		return map.values();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public void update(int productid, int quantity) {
		CartItem item = map.get(productid);

		item.setQuantity(quantity );
		if (item.getQuantity() <= 0) {
			map.remove(productid);
		}

	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getUnitPrice()).sum();
	}

	@Override
	public int getCount() {
		if (map.isEmpty()) {
			return 0;
		}
		return map.values().size();
	}
}
