import java.util.ArrayList;
import java.util.List;

public class pathSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        // if (targetSum == 0)
        // return result;
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> ans, List<List<Integer>> result) {
        if (root == null)
            return;
        ans.add(root.val);
        if (root.left == null && root.right == null && targetSum == root.val) {
            result.add(new ArrayList<>(ans));
        } else {
            dfs(root.left, targetSum - root.val, ans, result);
            dfs(root.right, targetSum - root.val, ans, result);
        }
        ans.remove(ans.size() - 1);

        // Backtracking karni padegi jaise neeche aate aate
        // list mei 1--2--3--4--5
        // Upar root tak aate hue we are removing 5-4-3-2 and then we are sending 1-->
        // to the right call.
        // Agar hum Backtracking karke remove karden sab to maze aajayengey ekdum.
    }
