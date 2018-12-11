import java.io.*;

public class Driver {
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		Lines lines = new Lines();
		System.out.println("hello Welcome to the shopping center!!!");
		System.out.println("Please specify stock.");
		System.out.print("How many items do you have?");
		int numItems = Integer.parseInt(stdin.readLine().trim());
		System.out.println(numItems);
		System.out.print("Please specify restocking amount:");
		int restocking = Integer.parseInt(stdin.readLine().trim());
		System.out.println(restocking);
		ShoppingCenter shop = new ShoppingCenter(restocking);
		for (int i = 0; i < numItems; i++) {
			System.out.print(">>Enter item name : ");
			String name = stdin.readLine().trim();
			System.out.println(name);
			System.out.println(">>How many " + name + "s? ");
			int stock = Integer.parseInt(stdin.readLine().trim());
			shop.addItem(i, name, stock);
			System.out.println(stock + " items of " + name + " placed in stock");
		}
		System.out.print(
				"Please select the checkout line that should check out customers first (regular1/regular2/express) ");
		String sel = stdin.readLine().trim();
		System.out.println(sel);
		lines.setLine(sel);
		System.out.println("\n\nPlease choose on of the following commands:");
		boolean contin = true;
		System.out.println("0. Close the Shopping Center");
		System.out.println("1. Customer Enters Shopping Center");
		System.out.println("2. Customer picks an item and places it in their shopping cart");
		System.out.println("3. Customer removes an item from their shopping cart");
		System.out.println("4. Customer is done shopping");
		System.out.println("5. Customer checks out");
		System.out.println("6. Print info about customers who are shopping");
		System.out.println("7. Print info about customers in checkout lines.");
		System.out.println("8. Print info about items at or below re-stocking level.");
		System.out.println("9. Reorder an item");

		do {
			System.out.print("\nPlease choose a menu command: ");
			String op = stdin.readLine().trim();
			System.out.println(op);
			switch (Integer.parseInt(op)) {
			case 0:
				System.out.println("Goodbye");
				contin = false;
				break;
			case 1:
				Customer customer;
				do {
					System.out.println(">>Enter customer name : ");
					String name = stdin.readLine().trim();
					customer = shop.findCustomer(name);
					if (customer == null) {
						shop.addCustomer(name);
						System.out.println("Customer " + name + " is now in the Shopping Center");
					} else {
						System.out.println("Customer " + name + " is already in shopping center!");
					}
				} while (customer != null);
				break;
			case 2:
				if (shop.getCustomersSize() != 0) {
					Customer set;
					boolean found = false;
					int i = 0;
					while(!found && i < 2)
					{
						System.out.print(">>Enter customer name : ");
						String sell = stdin.readLine().trim();
						System.out.println(sell);
						set = shop.findCustomer(sell);
						if (set != null) {
							found = true;
							System.out.print("What item does " + set.getName() + " want?: ");
							String itemName = stdin.readLine().trim();
							System.out.println(itemName);
							Item item = shop.findItem(itemName);
							if (item != null) {
								if (item.getStock() != 0) {
									item.setStock(-1);
									set.addItemToCart();
									shop.incrementTime();
									int items = set.getAmountInCart();
									if (items != 0) {
										System.out.println("Customer " + sell + " now has " + items
												+ " items in the shopping cart");
									} else {
										System.out.println("Customer " + sell + " now has 1 item in the shopping cart");
									}
								} else {
									System.out.println("Stock is empty");
								}
							} else {
								System.out.println("No " + itemName + " in shopping center");
							}
						} else {
							i++;
							System.out.println("No customer " + sell + " in shopping center");
						}
					} 
				} else {
					System.out.println("No one is in the Shopping Center!");
				}
				break;
			case 3:
				if (shop.getCustomersSize() != 0) {
					Customer k;
					do {
						System.out.print(">>Enter customer name : ");
						String names = stdin.readLine().trim();
						System.out.println(names);
						k = shop.findCustomer(names);
						if (k != null) {
							if (k.getAmountInCart() != 0) {
								k.removeItemFromCart();
								shop.incrementTime();
								System.out.println("Customer " + names + " has now " + k.getAmountInCart()
										+ " items in the shopping cart");
							} else {
								System.out.println("Customer " + names + " has nothing to remove ");
							}
						} else {
							System.out.println(" Customer " + names + " is in a checkoutline !");
						}
					} while (k == null);
				} else {
					System.out.println("No one is in the Shopping Center!");
				}
				break;
			case 4:
				if (shop.getCustomersSize() != 0) {
					Customer temp = shop.dequeue();
					if (temp.getAmountInCart() != 0) {
						System.out.println(lines.addCustomer(shop.dequeue()));
					} else {
						String name = temp.getName();
						System.out.print("Should customer Latias leave or keep on shopping? Leave?(Y/N):");
						String response = stdin.readLine().trim();
						System.out.println(response);
						switch (response) {
						case "Y":
							System.out.println(lines.addCustomer(shop.dequeue()));
							break;
						case "N":
							shop.addCustomer(temp);
							System.out.println("Customer " + name + " with 0 items returned to shopping");
							break;
						}
					}
				} else {
					System.out.println("No customers in the shopping center!");
				}
				break;
			case 5:
				Customer checkout = lines.deleteCustomer();
				if (checkout != null) {
					String name = checkout.getName();
					System.out.print("Should customer " + name + " check out or keep on shopping? Checkout?(Y/N):");
					String response = stdin.readLine().trim();
					System.out.println(response);
					switch (response) {
					case "N":
						shop.addCustomer(checkout);
						System.out.println("Customer " + name + " with " + checkout.getAmountInCart()
								+ " items returned to shopping");
						break;
					case "Y":
						System.out.println("Customer " + name + " is now leaving the Shopping Center.");
						break;
					}
				} else {
					System.out.println("No customers in any line!");
				}
				break;
			case 6:
				shop.printCustomers();
				break;
			case 7:
				lines.printCustomers();
				break;
			case 8:
				shop.printBelowRestock();
				break;
			case 9:
				System.out.print("Enter item name to be re-ordered :");
				String name = stdin.readLine().trim();
				System.out.println(name);
				Item reorder = shop.findItem(name);
				if (reorder != null) {
					System.out.print("Enter number of " + name + "s to be re-ordered: ");
					int num = Integer.parseInt(stdin.readLine().trim());
					System.out.println(num);
					reorder.setStock(num);
				} else {
					System.out.println(name + " is not in stock!");
				}
				break;

			default:
				break;
			}
		} while (contin);
	}
}