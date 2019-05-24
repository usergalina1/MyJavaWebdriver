package inheritance;

public class Family {
    String name;
    int age;
    boolean isMale;

    public void about() {
        String sex = (isMale) ? "Male" : "Female";
        System.out.printf("name: %s, age: %d, sex: %s\n", name, age, sex);
    }

    public void walksWithTheFamily() {
        System.out.println("walks with the family");
    }

    public void eatsWithMyFamily() {
        System.out.println("I like to eat with my family!");
    }

    public void visitGrandParents() {
        System.out.println("We usually visit our grandparents on weekend.");
    }

    public void happy() {
        System.out.println("We are happy!");

    }
}
