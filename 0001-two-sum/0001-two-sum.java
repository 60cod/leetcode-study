import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); 
        // key: 숫자 값, value: 인덱스

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        // 문제 조건상 항상 해가 존재
        throw new IllegalArgumentException("No valid solution");
    }
    // 시간 복잡도: O(n) - 배열 1회 순회
    // 공간 복잡도: O(n) - 해시맵 사용

}
