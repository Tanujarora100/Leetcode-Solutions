    public List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null)
            return result;
        stack.add(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pollLast();
            result.add(temp.val);
            for (int i = temp.children.size()-1; i >= 0;i--) {
                //Reverse loop Chalaodo till i>0 baaki sab same hai
                //Post Order Starts from Left side while preOrder starts from Right Side of Generic tree.
                stack.add(temp.children.get(i));
            }
        }
        return result;
    }
