public class OOPS_abstraction {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.eat();
        h.walk();
        System.out.println(h.color);

        Chicken c = new Chicken();
        c.eat();
        c.walk();
          
    }
}

abstract class Animal {
    String color;
    Animal() {
        color = "brown";
    }
    void eat() {
        System.out.println("animal eats");
    }

    abstract void walk(); // no implementation
}

class Horse extends Animal {
    void changecolor() {
        color = "dark brown";
    }
    void walk() {
        System.out.println("walks on 4 legs"); // implementation
    }
}

class Chicken extends Animal {
    void changecolor() {
        color = "yellow";
    }
    void walk() {
        System.out.println("walks on 2 legs");
    }
}
