   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (right == null)
            return left;

        else if (left == null)
            return right;

        else
            return root;
            //Same code for Binary Tree and Binary Search Tree.
    }
