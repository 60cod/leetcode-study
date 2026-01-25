import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int k, int remaining, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            if (remaining == 0) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int num = start; num <= 9; num++) {
            if (num > remaining) break; // pruning

            path.add(num);
            backtrack(num + 1, k, remaining - num, path, result);
            path.remove(path.size() - 1);
        }
    }
    // 시간 복잡도: O(9 choose k) - 가능한 조합 수
    // 공간 복잡도: O(k) - 재귀 스택 및 path 저장
}
