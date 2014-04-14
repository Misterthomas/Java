
package strategypattern;


public class Visa implements PaymentStrategy {

  private final String name;

  private final String cardNumber;

  

  public Visa(String name, String cardNumber) {

    super();

    this.name = name;

    this.cardNumber = cardNumber;

    

  }

 

  @Override

  public void pay(double amount) {

    System.out.println(amount + " paid using Visa.");

  }

 

}

