 static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr.get(i))
                st.pop();
            if (!st.isEmpty())
                ans.add(st.peek());
            else
                ans.add(-1);
            st.push(arr.get(i));
        }
        // Reverse Karna Zaruri hai coz right se add kar rahe hai.
        Collections.reverse(ans);
        return ans;
    }
