import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class RestaurantOwner {
	/*
	 * static HashMap to store all the food items and their respective price in
	 * menu. Declared static so as to share same menu for all customers.
	 */
	static HashMap<String, Float> menu;
	static String restaurantID = "restaurant";
	static String restaurantPW = "rest123";
	
	RestaurantOwner() {
		menu = new HashMap<String, Float>();
	}

	public boolean authorize(String username, String password) {
		return username.equals(restaurantID) && password.equals(restaurantPW);
	}
	
	public boolean checkmenu(String food) {//음식이 메뉴에 있는지 확인하는 것을 반복적으로 해서 만듬
		return menu.containsKey(food);
	}

	public boolean addItem(String food, float price) {
		/*
		 * If menu already contains the food item don't add it in menu again and return
		 * false, Else add the food item in menu and return true.
		 */
		if (checkmenu(food))
			return false;
		menu.put(food, price);
		return true;
	}

	public boolean deleteItem(String food) {
		/*
		 * First check if food item exists in menu. If exists then delete and return
		 * true, else return false
		 */
		if (checkmenu(food)) {
			menu.remove(food);
			return true;
		} else
			return false;
	}

	public boolean update(String food, float price) {
		/*
		 * First delete the existing food. If no such food is found, it adds food to the
		 * menu, else updates the price
		 */
		try {
			deleteItem(food);
			addItem(food, price);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public void displayMenu() {
		if (menu.isEmpty()) {
			printemptymenu();
		}
		Set<String> foodNames = new HashSet<String>();
		foodNames = menu.keySet();
		System.out.println("-------------------------------------");
		System.out.println("FOOD \t PRICE");
		System.out.println("-------------------------------------");
		for (String food : foodNames) {
			System.out.println(food + "\t" + menu.get(food));
		}
		System.out.println("-------------------------------------");
	}

	public void printemptymenu() {
		System.out.println("Menu empty.");
	}
}
