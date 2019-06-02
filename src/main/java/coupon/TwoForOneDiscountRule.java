package coupon;

import java.util.List;

public class TwoForOneDiscountRule implements DiscountRule {

	// This rule will set items that have quantity = 2 for the price of one.
	public boolean applyDiscount(List<CartItem> cartItems) {
		boolean discountApplied = false;
		for (CartItem item : cartItems) {
			if (item.getQuantity() >= 2 && item.getProduct().getName().equals("VOUCHER")) {
				item.addDiscount(item.getProduct().getPrice());
				discountApplied = true;
			}
		}
		return discountApplied;
	}

}
