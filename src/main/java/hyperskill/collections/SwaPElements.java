package hyperskill.collections;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SwaPElements {
    public static void main(String[] args) {
        // put your code here
        final Scanner scanner = new Scanner(System.in);
        final List<Integer> seq = Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<List<Integer>> swapPairs = new ArrayList<>();
        int countOfReplacment = scanner.nextInt();
        for (int i = 0; i < countOfReplacment; i++) {
            String[] str = scanner.nextLine().split("\\s");
            //Arrays.stream(str).flatMap(s-> Integer::parseInt())
            List<Integer> swapPair =
                    Arrays.stream(scanner.nextLine().split("\\s")).map(Integer::parseInt).collect(Collectors.toList());
            swapPairs.add(swapPair);
        }
        for (List<Integer> swapPair : swapPairs){
            Collections.swap(seq , swapPair.get(0), swapPair.get(1));
        }
        for (Integer integer : seq){
            System.out.print(integer + " ");
        }
    }
}
