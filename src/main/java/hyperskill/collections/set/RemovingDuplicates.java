package hyperskill.collections.set;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RemovingDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> stringSet = new TreeSet<>();
        int strCount = scanner.nextInt();
        for (int i = 0; i < strCount+1; i++) {
            stringSet.add(scanner.nextLine());
        }
        for(String str : stringSet){
            System.out.println(str);
        }
    }
}
