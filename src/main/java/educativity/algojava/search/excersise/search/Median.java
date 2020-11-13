package educativity.algojava.search.excersise.search;

public class Median {
    public static int getMedian(int array1[], int array2[]) {
        Integer med1 = null;
        Integer med2 = null;
        if (array1.length > 2) {
            med1 = getMedianForOneArr(array1, array1.length % 2 == 0);
        }
        if (array2.length > 2) {
            med2 = getMedianForOneArr(array2, array2.length % 2 == 0);
        }
        if (med1 != null || med2 != null) {
            if(med1==null){
                return med2;
            } else if(med2 ==null){
                return med1;
            }
            return (med1 + med2) /2;
        }
        return Integer.MIN_VALUE;
    }

    public static int getMedianForOneArr(int[] src, boolean isOdd) {
        if (isOdd) {
            return (src[src.length / 2 - 1] + src[src.length / 2 + 1]) / 2;
        } else {
            return src[(src.length - 1) / 2 + 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(Median.getMedian(new int[]{100}, new int[]{1, 5, 8, 10, 20}));
    }
}
