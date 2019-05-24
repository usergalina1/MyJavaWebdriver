package inheritance;

import org.testng.annotations.Test;

public class TestInheritance {
    @Test
    public void testFamily() {
        Father father = new Father();
        father.name = "Tom";
        father.age = 45;

        Mother mother = new Mother();
        mother.name = "Helen";
        mother.age = 42;

        Son son = new Son();
        son.name = "Peter";
        son.age = 21;

        Daughter daughter = new Daughter();
        daughter.name = "Jane";
        daughter.age = 16;

        System.out.println("My family:");
        Family[] members = new Family[4];
        members[0] = father;
        members[0].isMale = true;
        members[1] = mother;
        members[2] = son;
        members[2].isMale = true;
        members[3] = daughter;
        for (Family f : members) {
            f.about();
        }
        father.works();
        mother.cooks();
        mother.walksWithTheFamily();
        mother.walksWithTheFamily(" with us");
        son.study();
        son.be();
        son.play();
        daughter.studies(" school");
        son.eatsWithMyFamily();
        daughter.visitGrandParents();
        father.happy();
    }
}
