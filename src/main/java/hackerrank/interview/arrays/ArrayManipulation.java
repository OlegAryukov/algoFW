package hackerrank.interview.arrays;

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        long[] srcArray = new long[n];
        long max = queries[0][2];
        long maxInt = queries[0][1] - queries[0][0];
        int maxIntIndx = 0;
        srcArray[0] = queries[0][2];
        int queryLength = queries.length;
        for (int i = 1; i < queryLength; i++) {
            if((queries[i][1] - queries[i][0]) > maxInt){
                maxInt = queries[0][1] - queries[0][0];
                maxIntIndx = i;
            }
        }
        for (int i = 1; i < queryLength; i++) {
            if(queries[i][0] <= queries[maxIntIndx][1] && queries[i][1] >= queries[maxIntIndx][0] && queries[i][1] >=queries[i-1][0] && queries[i][0]<=queries[i-1][0]){
                max += queries[i][2];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] input = {{2, 6, 8},
                        {3, 5, 7},
                        {1, 8, 1},
                        {5, 9, 15}};
        int[][] input2 = {
                {29, 40, 787},
                {9,  26, 219},
                {21, 31, 214},
                {8,  22, 719},
                {15, 23, 102},
                {11, 24, 83},
                {14, 22, 321},
                {5,  22, 300},
                {11, 30, 832},
                {5,  25, 29},
                {16, 24, 577},
                {3,  10, 905},
                {15, 22, 335},
                {29, 35, 254},
                {9,  20, 20},
                {33, 34, 351},
                {30, 38, 564},
                {11, 31, 969},
                {3,  32, 11},
                {29, 35, 267},
                {4,  24, 531},
                {1,  38, 892},
                {12, 18, 825},
                {25, 32, 99},
                {3,  39, 107},
                {12, 37, 131},
                {3,  26, 640},
                {8,  39, 483},
                {8,  11, 194},
                {12, 37, 502}
        };
        System.out.println(ArrayManipulation.arrayManipulation(30, input2));
    }
}
