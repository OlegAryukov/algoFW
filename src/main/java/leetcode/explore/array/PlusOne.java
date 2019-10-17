package leetcode.explore.array;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int tmp = 0;
        if(digits.length ==1 && digits[0] + 1 == 10){
            return new int[]{1,0};
        }
        if (digits[digits.length-1] + 1 ==10){
            tmp = 1;
        } else {
            digits[digits.length-1] = digits[digits.length-1] +1;
        }
        for (int i = digits.length - 1; i >= 1; i--) {
            if (tmp == 1){
                digits[i] = 0;
                if (digits[i - 1] + 1 == 10){
                    tmp = 1;
                    digits[i-1] = 0;
                } else {
                    digits[i-1] = digits[i-1] + 1;
                    tmp = 0;
                }
            }
        }
        if(tmp == 1){
            int[] res = new int[digits.length +1];
            System.arraycopy(digits, 0, res, 1, digits.length-1);
            res[0] = 1;
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] res = po.plusOne(new int[]{1,2,3});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
