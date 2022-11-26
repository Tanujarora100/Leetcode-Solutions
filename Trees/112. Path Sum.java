public class pathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && targetSum - root.data == 0)
            return true;

        else
            return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);

    }
}
