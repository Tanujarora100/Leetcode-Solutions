  public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        if (root.val > L) {
            sum += rangeSumBST(root.left, L, R);
        } // left child is a possible candidate.
        if (root.val < R) {
            sum += rangeSumBST(root.right, L, R);
        } // right child is a possible candidate.

        return sum;
    }
