package coupon;

public class CartItem {
	private Product product;
	private Integer quantity;
	private Double discount;
	private Double discountPercent;
	private Double netAmount;

	public Product getProduct() {
		return product;
	}

	public CartItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
		this.discount = 0.0d;
		this.discountPercent = 0.0d;
		this.netAmount = product.getPrice() * quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getDiscount() {
		return discount;
	}
	
	public Double addDiscount(Double disc) {
		this.discount += disc;
		return this.discount;
	}

	public Double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(Double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}
}
