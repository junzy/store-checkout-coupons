package coupon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basket {

	// Map storing products and their counts. using a map as this will optimize
	// adding and removal of products from Baskets containing more items.
	Map<Product, Integer> items;

	public Basket() {
		items = new HashMap<>();
	}

	public Map<Product, Integer> getItems() {
		return items;
	}

	public void addProduct(Product product) {
		if (items.containsKey(product)) {
			items.put(product, items.get(product) + 1);
		} else {
			items.put(product, 1);
		}
	}

	public void removeProduct(Product product) {
		if (items.get(product).intValue() > 1) {
			items.put(product, items.get(product) - 1);
		} else {
			items.remove(product);
		}
	}

	public void addProducts(List<Product> products) {
		if (products != null && !products.isEmpty()) {
			for (Product product : products) {
				addProduct(product);
			}
		}
	}

	/**
	 * Converts the items map to a cartItems List.
	 *
	 * @return the list
	 */
	public List<CartItem> checkout() {
		List<CartItem> cartItems = new ArrayList<>();
		for (Map.Entry<Product, Integer> entry : items.entrySet()) {
			cartItems.add(new CartItem(entry.getKey(), entry.getValue()));
		}
		return cartItems;
	}	
}