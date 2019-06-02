package coupon;

import java.util.List;

public class BuyXLowerPriceRule implements DiscountRule {

	@Override
	public boolean applyDiscount(List<CartItem> cartItems) {
		boolean discountApplied = false;
		for (CartItem item : cartItems) {
			if (item.getQuantity() >= 3 && item.getProduct().getName().equals("TSHIRT")) {
				item.addDiscount(item.getQuantity() * 1.0d);
				discountApplied = true;
			}
		}
		return discountApplied;
	}

}
