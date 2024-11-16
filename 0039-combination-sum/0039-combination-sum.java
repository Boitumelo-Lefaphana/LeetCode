import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        if (target < 0) {
            return; // Target exceeded, backtrack
        }
        if (target == 0) {
            result.add(new ArrayList<>(current)); // Found a combination, add to result
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]); // Choose the candidate
            backtrack(candidates, target - candidates[i], i, current, result); // Explore with the current candidate
            current.remove(current.size() - 1); // Undo the choice
        }
    }
}
