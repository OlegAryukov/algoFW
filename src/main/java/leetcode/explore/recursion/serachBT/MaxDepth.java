package leetcode.explore.recursion.serachBT;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = root.left == null ? 1 : depth(2, root.left);
        int right = root.right == null ? 1 : depth(2, root.right);
        return Math.max(left, right);
    }

    private int depth(int init, TreeNode root) {
        int rightDepth = 0;
        int leftDepth = 0;
        if (root.left == null && root.right == null) {
            return init;
        }
        if (root.right != null) {
         rightDepth = depth(init + 1, root.right);
        }
        if( root.left!=null) {
            leftDepth = depth(init + 1, root.left);
        }

        return Math.max(leftDepth, rightDepth);
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
//        one.left = two;
//        one.right = three;
//        two.left = four;
//        three.right = five;

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        four.left = six;
        five.left = seven;
        seven.left = eight;
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth2(one));
    }
}
