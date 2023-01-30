public class OOPS {
    public static void main(String args[]) {
        Pen p1 = new Pen(); // created a pen object called p1
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        // p1.setColor("Yellow");
        p1.setColor("Yellow");
        System.out.println(p1.getColor());

        BankAccount myAcc = new BankAccount();
        myAcc.username = "mayank";
        myAcc.setPassword("abcdefg");

        Student s1 = new Student("mayank");
        System.out.println(s1.name);
    }
}

class Pen {
    private String color; // proprerties
    private int tip;

    String getColor() {
        return this.color; // 'this'- keyword used to access the properties of the object
    }
    int getTip() {
        return this.tip;
    }

    void setColor(String newColor) { // functions
        this.color = newColor;
    }

    void setTip(int newTip) {
        this.tip = newTip;
    }
}

class Student {
    String name;
    int age;

    Student(String name) { // if you have to initialize then pass argu < parameterized
        this.name = name;  // or Student(){ soutln("constructor is called...");} < non-parameterized
    }
    // float percentage; // cgpa

    // void calcPercentage(int phy, int chem, int math) {
    //     percentage = (phy + chem + math) / 3;
    // }
}

class BankAccount {
    public String username;
    //private String password;

    public void setPassword(String pwd) {
        //password = pwd;
    }
}
