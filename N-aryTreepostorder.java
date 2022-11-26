 public List<Integer> postorder(Node root) {
        List<Integer> result= new LinkedList();
        LinkedList<Node> stack = new LinkedList<>();
     if(root==null) return result;
        stack.addFirst(root);
        
        while(!stack.isEmpty())
        {
            Node temp= stack.pollLast();
            result.add(temp.val);
            for(int i=0; i<temp.children.size();i++)
            {
                stack.add(temp.children.get(i));
            }
        }
        Collections.reverse(result);
        return result;
    }
