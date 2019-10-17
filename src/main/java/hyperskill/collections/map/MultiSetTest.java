package hyperskill.collections.map;

public class MultiSetTest {
    public static void main(String[] args) {
        Multiset<String> multisetA = new HashMultiset<>();
        Multiset<String> multisetB = new HashMultiset<>();
        Multiset<String> multisetC = new HashMultiset<>();
        multisetA.add("a");
        multisetA.add("a");
        multisetA.add("f");
        multisetA.add("f");
        multisetA.add("f");
        multisetA.add("b");
        multisetA.add("b");
        multisetA.add("b");
        multisetA.add("c");


        multisetB.add("a");
        multisetB.add("a");
        multisetB.add("a");
        multisetB.add("b");
        multisetB.add("b");
        multisetB.add("c");
        multisetB.add("c");
        multisetB.add("c");
        multisetB.add("d");
        multisetB.add("d");


        System.out.println("Uniq : " + multisetA.numberOfUniqueElements() + "\n" + "Full size : " + multisetA.size());
        multisetA.intersect(multisetB);
        System.out.println("Uniq : " + multisetA.numberOfUniqueElements() + "\n" + "Full size : " + multisetA.size());
        multisetA.union(multisetB);
        System.out.println("Uniq : " + multisetA.numberOfUniqueElements() + "\n" + "Full size : " + multisetA.size());

        multisetC.intersect(multisetA);
        System.out.println("Uniq : " + multisetC.numberOfUniqueElements() + "\n" + "Full size : " + multisetC.size());

        multisetA.intersect(multisetC);
        System.out.println("Uniq : " + multisetA.numberOfUniqueElements() + "\n" + "Full size : " + multisetA.size());
    }
}
