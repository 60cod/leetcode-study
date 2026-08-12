import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int start, int[] nums,
                           List<Integer> path, List<List<Integer>> result) {
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);

            backtrack(i + 1, nums, path, result);

            path.remove(path.size() - 1);
        }
    }
}

// 시간 복잡도 - O(n * 2^n), n은 배열 nums의 길이
// 공간 복잡도 - O(n), 결과 리스트 제외