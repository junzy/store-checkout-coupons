package coupon;

public class Product {

	private String name;
	private Double price;
	private String description;

	public Product(String name, Double price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// this allows us to use a Product obj as a key in a map.
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Product product = (Product) o;
		if (name != null ? !name.equals(product.name) : product.name != null)
			return false;
		return price != null ? price.equals(product.price) : product.price == null;
	}

	// this allows us to use a Product obj as a key in a map.
	@Override
	public int hashCode() {
		int result = 1;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
