package inheritance;

public class Mother extends Family {
    public void cooks() {
        System.out.println("My mother usually cooks!");
    }

    public void walksWithTheFamily() {
        System.out.println("In addition, my Mother usually walks with daughter");
    }

    public void walksWithTheFamily(String arg) {
        System.out.println("or sometimes she walks" + arg + ".");
    }
}
