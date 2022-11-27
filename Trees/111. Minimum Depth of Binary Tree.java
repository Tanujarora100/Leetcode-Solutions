public int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    if (root.left == null & root.right == null)
      return 1;
    // Seedha Return karwado jaise hi leaf node mile
    // Leaf Node means ki mujhe aage nhi check karna i am done.
    int l = Integer.MAX_VALUE;
    int r = Integer.MAX_VALUE;
    if (root.left != null) {
      l = minDepth(root.left);
    }
    if (root.right != null) {
      r = minDepth(root.right);
    }
    return 1 + Math.min(l, r);
  }
