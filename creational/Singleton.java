package creational;

public class Singleton {
    public static void main(String[] args) {
        SingletonClass.getInstance();
        SingletonClass.getInstance();
        SingletonClass.getInstance();
    }
}
class SingletonClass{
    // The field must be declared volatile so that double check lock would work
    // correctly.

    // volatile keyword here makes sure that
   // the changes made in one thread are 
   // immediately reflect in other thread
    private static volatile SingletonClass obj;

    private SingletonClass() {
        System.out.println("This is a Private Constructor");
    }
    
    // For Simpler understanding
    // public static SingletonClass getInstance(){
    //     if (obj!=null) {
    //         return obj;
    //     }
    //     obj = new SingletonClass();
    //     return obj;
    // }


    // This is thread safe method.
    public static SingletonClass getInstance(){
        SingletonClass temp = obj;
        if(temp!=null){
            return temp;
        }
        synchronized(SingletonClass.class) {
            if (obj == null) {
                obj = new SingletonClass();
            }
            return obj;
        }
    }

        // The approach taken here is called double-checked locking (DCL). It
        // exists to prevent race condition between multiple threads that may
        // attempt to get singleton instance at the same time, creating separate
        // instances as a result.
        //
        // It may seem that having the `result` variable here is completely
        // pointless. There is, however, a very important caveat when
        // implementing double-checked locking in Java, which is solved by
        // introducing this local variable.
        //
        // You can read more info DCL issues in Java here:
        // https://refactoring.guru/java-dcl-issue



}

// Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
// Issues with multi threading. Create a thread safe environment.

// Implement in two steps:
// 1. make constructor private
// 2. Static method for calling static obj. 