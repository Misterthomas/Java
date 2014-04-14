
package strategypattern;

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ShoppingCart cart = new ShoppingCart();
         
        Product item1 = new Product("shoes","Nike",10);
        Product item2 = new Product("shoes","Puma",10);
         
        cart.addItem(item1);
        cart.addItem(item2);
         
        //pay by paypal
        cart.pay(new PayPal("email@example.com", "password"));
         
        //pay by credit card
        cart.pay(new Visa("Frank", "1234567890123456"));
        
        //pay by mastercard
        cart.pay(new MasterCard("Bob", "1234567890123456"));
        
    }
}
