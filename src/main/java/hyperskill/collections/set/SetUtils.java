package hyperskill.collections.set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetUtils {

    public static Set<Integer> getSetFromString(String str) {
        String[] strSrc = str.split("\\s");
        Set<Integer> integerSet = new HashSet<>();
        for (String s : strSrc) {
            integerSet.add(Integer.parseInt(s));
        }
        return integerSet;
    }

    public static void removeAllNumbersGreaterThan10(Set<Integer> set) {
        set.removeIf(integer -> integer>10);
    }



/* Do not change code below */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();

        Set<Integer> set = SetUtils.getSetFromString(numbers);
        SetUtils.removeAllNumbersGreaterThan10(set);
        set.forEach(e -> System.out.print(e + " "));
    }
}
