package coupon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Welcome to NoviCaps checkout system");
		Thread.sleep(10000);
		try {
			// the path to the input file ie,. products.json. 
			// I Have assumed that the input given is the final list of products that are to be purchased.
			String inputPath = "products.json";
			List<Product> products = parseProducts(inputPath);
			if (!products.isEmpty()) {
				Basket basket = new Basket();
				basket.addProducts(products);
				// let's checkout the basket now, converts products to CartItems.
				System.out.println(PriceCalculator.calculatePrice(basket.checkout()));
			}

		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Not enough parameters. arg1 = input file path");
		}
	}

	/**
	 * Parses the file into a product List. we assume that the input json doesnt
	 * contain duplicates and contains sanitized data.
	 *
	 * @param inputPath
	 *            the input path
	 */
	private static List<Product> parseProducts(String inputPath) {
		JSONArray array = null;
		List<Product> products = new ArrayList<>();
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		try {
			array = (JSONArray) jsonParser.parse(new FileReader(inputPath));
			for (Object item : array) {
				JSONObject product = (JSONObject) item;
				Product prod = new Product((String) product.get("code"), (Double)product.get("price"), (String) product.get("name"));
				products.add(prod);
			}
		} catch (IOException e) {
			// ideally we would use a logger of some sort here, but outputting to System.out
			// here for the sake of simplicity
			System.out.println("Error parsing input file. File read was interrupted.");
		} catch (org.json.simple.parser.ParseException e) {
			// we should ideally log this as well.
			e.printStackTrace();
		} finally {
			return products;
		}
	}

}
