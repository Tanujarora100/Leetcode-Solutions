    public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Solve(K, N, new ArrayList<>(), ans, 1);
        return ans;

    }

    public static void Solve(int k, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans, int start) {
        if (target == 0 && list.size() == k) {
            ans.add(new ArrayList<>(list));
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            Solve(k, target - i, list, ans, i + 1);
            list.remove(list.size() - 1);
        }
    }
