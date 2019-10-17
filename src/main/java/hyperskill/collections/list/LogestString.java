package hyperskill.collections.list;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LogestString {
    public static List<Integer> createLinkedList(String str) {
        List<Integer> ll = new LinkedList<>();

        String[] strSrc = str.split("\\s");
        int lenght = strSrc.length;
        int[] src = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            src[i] = Integer.parseInt(strSrc[i]);
        }
        Arrays.sort(src);
        for (int value : src) {
            ll.add(value);
        }
        return ll;
    }

    public static void modifyLinkedList(List<Integer> list, int num) {
//        Iterator<Integer> iterator = list.iterator();
//        int checker = 0;
//        while (iterator.hasNext()){
//            if(checker%num==0){
//                list.remove(iterator.next());
//            }
//            checker++;
//        }
        int count = list.size() / num;
        while (count != 0) {
            list.remove((num) * count - 1);
            count--;
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
//        String str = new String("1 6 4 3 5 2 8 7 9");
        int num = scanner.nextInt();
        List<Integer> ll = LogestString.createLinkedList(str);
        LogestString.modifyLinkedList(ll, num);
        ll.forEach(e -> System.out.print(e + " "));
    }
}
