package task1;

public class Person {
    private String name;
    private int age;

    public Person(){
        this.name = "Ember";
        this.age = 25;
    }
    public void displayInfo(){
        System.out.printf("Name: %s, Age: %d\n%n",name,age);
    }
}
