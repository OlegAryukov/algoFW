package hackerrank.interview.sorting;

import java.util.Arrays;

public class NotoficationProblem {
    static int activityNotifications(int[] expenditure, int d) {
        int endIndex = expenditure.length - (d + 1);
        int notificationCount = 0;
        boolean isOdd = d % 2 == 0;
        int medIndex = isOdd ? d / 2 : (d - 1) / 2;

        int[] sortedSrc = Arrays.copyOf(expenditure, d);
        int indexForAdding = 0;
        Arrays.sort(sortedSrc);
        for (int i = 0; i <= endIndex; i++) {
            if (isOdd) {
                if (i > 0) {
                    if ((sortedSrc[i + medIndex - 1] > expenditure[i + d - 1])) {
                        indexForAdding++;
                    } else if ((sortedSrc[i + medIndex + 1] < expenditure[i + d - 1])) {
                        indexForAdding--;
                    }
                }
                if ((sortedSrc[i + medIndex - 1 + indexForAdding] + sortedSrc[medIndex + 1 + indexForAdding]) <= expenditure[i + d]) {
                    notificationCount++;
                }
            } else {
                if (i > 0) {
                    if ((sortedSrc[i + medIndex] < expenditure[i + d - 1])) {
                        indexForAdding--;
                    }
                }
                if ((sortedSrc[i + (medIndex) + indexForAdding] * 2) <= expenditure[i + d]) {
                    notificationCount++;
                }
            }
        }
        return notificationCount;
    }

    static int actNotVer2(int[] expenditure, int d) {
        int endIndex = expenditure.length - (d + 1);
        int notificationCount = 0;
        boolean isOdd = d % 2 == 0;
        int medIndex = isOdd ? d / 2 : (d - 1) / 2;

        for (int i = 0; i <= endIndex; i++) {
            Arrays.sort(expenditure, i, i + d);
            if (isOdd) {
                if ((expenditure[i + medIndex - 1] + expenditure[medIndex + 1]) <= expenditure[i + d]) {
                    notificationCount++;
                }
            } else {
                if ((expenditure[i + (medIndex)] * 2) <= expenditure[i + d]) {
                    notificationCount++;
                }
            }
        }
        return notificationCount;
    }

    public static void main(String[] args) {
        int[] src = new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5};
        System.out.println(NotoficationProblem.activityNotifications(src, 5));
        int[] src2 = new int[]{1, 2, 3, 4, 4};
        System.out.println(NotoficationProblem.activityNotifications(src2, 4));
        int[] src3 = new int[]{10, 20, 30, 40, 50};
        System.out.println(NotoficationProblem.activityNotifications(src3, 3));

    }
}
