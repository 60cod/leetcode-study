class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;  // XOR 연산
        }
        return result;
    }
    // Time Complexity: O(n)
    // Space Complexity: O(1) (추가 변수 한 개 사용)
}
