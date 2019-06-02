package coupon;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {

	/* considering a single threaded application where there exists only one set of
	applicable discounts application wide.*/

	static List<DiscountRule> rules;
	static {
		/* apply discount rules in prioritized order
		 the rules are applied one on top of the other. so multiple discounts are applicable.*/
		rules = new ArrayList<>();
		rules.add(new TwoForOneDiscountRule());
		rules.add(new BuyXLowerPriceRule());
	}
	
	private PriceCalculator() {
	    throw new IllegalStateException("Utility class not meant to be instantiated.");
	  }


	/**
	 * Calculate price of given list of cart items, by applying configured discount rules.
	 *
	 * @param cartItems the cart items
	 * @return the float
	 */
	public static float calculatePrice(List<CartItem> cartItems) {
		for (DiscountRule rule : rules) {
			// If multiple discounts are applicable on same item, we should store a discount applied flag at cartItem level.
			rule.applyDiscount(cartItems);
		}
		/* cartItems now have the updated prices based on discount rules.
		 It's possible to add cart-wide discounts at this stage.*/
		float finalPrice = 0.0f;
		for (CartItem item : cartItems) {
			finalPrice += item.getNetAmount() - item.getDiscount();
		}
		return finalPrice;
	}

}
