package educativity.algojava.search.excersise.search;

public class SparseSearch {
        public static int modifiedBinarySearch(String[] arr, int low, int high, String target) {
            if (low > high)
                return -1;
            //calculating mid value
            int mid = (low + high) / 2;

            // Our modification
            if (arr[mid] == "") {
                int i = mid - 1;
                int j = mid + 1;
                while (true) {
                    if (i < low && j > high)
                        return -1;

                    if (i >= low && arr[i] != "") {
                        mid = i;
                        break;
                    } else if (j <= high && arr[j] != "") {
                        mid = j;
                        break;
                    }
                    i--;
                    j++;
                }
            }

            // Now perform simple Binary Search
            if (arr[mid].equals(target))
                return mid;
            else if (arr[mid].compareTo(target) > 0)
                return modifiedBinarySearch(arr, low, mid - 1, target);
            else
                return modifiedBinarySearch(arr, mid + 1, high, target);
        }

        public static int searchForString(String[] array, String target) {
            return modifiedBinarySearch(array, 0, array.length - 1, target);
        }
        public static void main(String args[]) {
            String[] array = {
                    "",
                    "educative",
                    "",
                    "",
                    "",
                    "hello",
                    "",
                    "learning",
                    "world",
                    "",
                    "",
                    ""
            };
            String[] targetArray = {
                    "educative",
                    "learning"
            };

            for (int i = 0; i < 2; i++) {
                System.out.println(targetArray[i] + ": " + searchForString(array, targetArray[i]));
            }
        }
}
