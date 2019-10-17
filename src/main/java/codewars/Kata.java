package codewars;

import java.util.Arrays;

public class Kata {
    //Bad solution. Use format string
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < numbers.length; i++) {
            if (i == 3) {
                stringBuilder.append(")");
                stringBuilder.append(" ");
                stringBuilder.append(numbers[i]);
            } else if (i == 6) {
                stringBuilder.append("-");
                stringBuilder.append(numbers[i]);
            } else {
                stringBuilder.append(numbers[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static int findEvenIndex(int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        int startNum = arr[0];
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            if (res != 0) {
                break;
            }
            if (startNum == (totalSum - (startNum + arr[i]))) {
                res = i;
            } else {
                startNum = startNum + arr[i];
            }
        }
        return res > 0 ? res : -1;
    }

    public static void main(String[] args) {
        System.out.println(Kata.findEvenIndex(new int[]{20, 10, 30, 10, 10, 15, 35}));
    }
}