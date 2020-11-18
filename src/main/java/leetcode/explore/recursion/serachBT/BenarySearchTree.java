package leetcode.explore.recursion.serachBT;

public class BenarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode();
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            if (root.right != null) {
                return searchBST(root.right, val);
            }
            return null;
        }
        if (root.left != null) {

            return searchBST(root.left, val);
        }
        return null;
    }

    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || val == root.val) return root;

        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
