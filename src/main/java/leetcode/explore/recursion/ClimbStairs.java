package leetcode.explore.recursion;

public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        for (int i = 3; i < n + 1; i++) {
            int tmp = f2;
            f2 += f1;
            f1 = tmp;
        }
        return f2+f1;
    }

    public static void main(String[] args) {
        System.out.println(ClimbStairs.climbStairs(3));
    }
}
