package creational;

//Product Interface:
interface Pizza{
    void prepare();
}

//ConcreteProduct implementation
class MargaritaPizza implements Pizza{
    MargaritaPizza(){
        prepare();
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Margarita");
    }
}

class PepperoniPizza implements Pizza{
    PepperoniPizza(){
        prepare();
    }
    @Override
    public void prepare() {
        System.out.println("Preparing Pepperoni Pizza");
    }
}

// Creator Interface
interface PizzaFactory{
    Pizza createPizza();
}
// ConcreteCreator class
class MargheritaPizzaFactory implements PizzaFactory{

    @Override
    public Pizza createPizza() {
        return new MargaritaPizza();
    }
}
class PepperoniPizzaFactory implements PizzaFactory{

    @Override
    public Pizza createPizza() {
        return new PepperoniPizza();
    }
}
// Client Code
public class FactoryMethod {
    public static void main(String[] args) {
//      The client code asks the user for a choice, picks the corresponding Creator, and then uses that creator for the rest of the application's lifecycle
//      The choice is made using if statements or switch cases.

        PizzaFactory pizzaFactory = new MargheritaPizzaFactory();
        pizzaFactory.createPizza();
        pizzaFactory = new PepperoniPizzaFactory();
        pizzaFactory.createPizza();
    }
}