
    static node mirror(node root) {
        if (root == null)
            return null;
        mirror(root.left);
        mirror(root.right);

        // Inverting the Nodes here.
        node temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
