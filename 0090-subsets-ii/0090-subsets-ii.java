import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] nums,
            int start,
            List<Integer> current,
            List<List<Integer>> result
    ) {
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);
            backtrack(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// 시간 복잡도 - O(n * 2^n), n은 배열의 길이
// 공간 복잡도 - O(n), 재귀 스택과 현재 부분집합을 위한 추가 공간, 반환 리스트 제외