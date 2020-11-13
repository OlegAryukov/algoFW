package educativity.algojava.search.excersise.greedy;

public class MaxThives {
    public static int policeThief(char[] arr, int k) {
        int count = 0;
        char police = 'P';
        char thief = 'T';
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == police) {
                if (i - k >= 0) {
                    if (arr[i - k] != ' ' && arr[i - k] == thief) {
                        count++;
                        arr[i - k] = ' ';
                    }
                } else if (i + k < arr.length) {
                    if(arr[i + k] != ' ' && arr[i + k] == thief) {
                        count++;
                        arr[i + k] = ' ';
                    }
                }
            }
        }
        return count;
    }
}
