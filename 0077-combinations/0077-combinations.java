import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, n, k, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, int n, int k,
                           List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);

            backtrack(i + 1, n, k, path, result);

            path.remove(path.size() - 1);
        }
    }
}

// 시간 복잡도 - O(k * C(n, k)), n은 숫자의 범위 크기, k는 선택할 숫자의 개수
// 공간 복잡도 - O(k), 결과 리스트 제외