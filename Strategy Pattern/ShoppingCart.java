
package strategypattern;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {

	private final List < Product > items;

	public ShoppingCart() {
		items = new ArrayList < Product > ();
	}

	public void addItem(Product item) {
		items.add(item);
	}

        public void removeItem(Product item){
                 items.remove(item);
        }

	public double calcTotalCost() {
		double total = 0.0;
		for (Product item: items) {
		total += item.getProductPrice();
		}
		return total;
	}


	public void pay(PaymentStrategy method) {
                double totalCost = calcTotalCost();
                method.pay(totalCost);
  }

}

