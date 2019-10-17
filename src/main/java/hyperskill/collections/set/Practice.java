package hyperskill.collections.set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Practice {
    public static void main(String[] args) {

        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        Iterator<String> iter = nameSet.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
