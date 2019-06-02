package coupon;

import java.util.List;

public interface DiscountRule {
	public boolean applyDiscount(List<CartItem> cartItems);
}
