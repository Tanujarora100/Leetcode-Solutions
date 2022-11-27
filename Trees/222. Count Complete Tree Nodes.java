 public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //Just do a Post Order traversal and get the answer.
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    // Time Complexity-O(N)

    // Less than O(N) Solution Required

    public int leftDepth(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }

    public int rightDepth(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }

    public int countNodes2(TreeNode root) {
        int left = leftDepth(root);
        int right = rightDepth(root);

        if (left == right)
            return (int) Math.pow(2, left) - 1;
        // Formula of nodes is 2^height-1 nodes are there in a perfect binary tree.
        else
            return 1 + countNodes2(root.left) + countNodes2(root.right);
    }
