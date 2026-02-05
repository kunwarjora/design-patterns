package creational;

// Abstract Product
interface Chair{
    void sitOn();
}
interface Sofa{
    void lieOn();
}

// Concrete Product
class ModernChair implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Modern chair!!");
    }
}

class VictorianChain implements Chair{
    @Override
    public void sitOn() {
        System.out.println("Victorian Chair!!");
    }
}

class ModernSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("Lying on a modern sofa.");
    }
}
class VictorianSofa implements Sofa{
    @Override
    public void lieOn() {
        System.out.println("Lying on victorian sofa.");
    }
}

// Abstract Factory
interface FurnitureFactory{
    Chair createChair();
    Sofa createSofa();
}

// Concrete Factory
class ModernFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }
}

class VictorianFurnitureFactory implements FurnitureFactory{

    @Override
    public Chair createChair() {
        return new VictorianChain();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }
}

class FurnitureClient {
    private final Chair chair;
    private final Sofa sofa;

    // The client receives a factory and works with abstract types
    public FurnitureClient(FurnitureFactory factory) {
        this.chair = factory.createChair();
        this.sofa = factory.createSofa();
    }

    public void useFurniture() {
        chair.sitOn();
        sofa.lieOn();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        // Choose the desired factory at runtime (e.g., based on config)
        FurnitureFactory factory = new ModernFurnitureFactory();
        FurnitureClient client = new FurnitureClient(factory);
        client.useFurniture();

        System.out.println("\nSwitching to Victorian style:");
        // Switch to a different factory easily
        FurnitureFactory victorianFactory = new VictorianFurnitureFactory();
        FurnitureClient victorianClient = new FurnitureClient(victorianFactory);
        victorianClient.useFurniture();

    }
}