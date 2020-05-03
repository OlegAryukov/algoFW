package leetcode.challange;

public class HappyNumber {
    public static boolean isHappy(int n) {
        boolean resBool = false;
        try{
            char[] chars = String.valueOf(n).toCharArray();
            int res = 0;
            for (int i = 0; i <chars.length ; i++) {
                res += Math.pow(Integer.valueOf(String.valueOf(chars[i])),2);
            }
            if(res==1){
                resBool = true;
                return true;
            } else {
                resBool = isHappy(res);
            }
        }catch (StackOverflowError error){
            resBool = false;
        }finally {
            return resBool;
        }
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.isHappy(19));
    }
}
