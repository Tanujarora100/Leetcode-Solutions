 int count = 0;

    TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        Set<Integer> found = new HashSet<>();
        TreeNode node = dfs(root, p, q, found);
        return found.size() == 2 ? node : null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result = found(root, p, q);
        return count == 2 ? result : null;
    }

    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q, Set<Integer> found) {
        // Using set
        if (root == null)
            return null;
        TreeNode l = dfs(root.left, p, q, found);
        TreeNode r = dfs(root.right, p, q, found);
        if (root.val == p.val || root.val == q.val) {
            found.add(root.val);
            return root;
        }
        // Always do a Post order traversal in this question.
        // If two target nodes are on separate branches, LCA is the root.
        if (l != null && r != null)
            return root;
        // one node is on one branch or none was found in both branches.
        return l != null ? l : r;
        // If left is not null then return left otherwise return right;
    }

    public TreeNode found(TreeNode root, TreeNode p, TreeNode q) {
        // Using Global Variable
        // Always do a Post order traversal in this question.
        if (root == null)
            return null;
        TreeNode left = found(root.left, p, q);
        TreeNode right = found(root.right, p, q);
        if (root.val == p.val || root.val == q.val) {
            count++;
            return root;
        }
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }
//InOrder Traversal and PreOrder Traversal giving some errors in edge cases.
