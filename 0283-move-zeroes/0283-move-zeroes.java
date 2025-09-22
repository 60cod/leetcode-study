class Solution {
    public void moveZeroes(int[] nums) {
        int pos = 0; // 0이 아닌 숫자를 채워 넣을 위치
        
        // Step 1: 0이 아닌 원소를 앞으로 복사
        for (int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        
        // Step 2: 남은 공간을 0으로 채움
        while (pos < nums.length) {
            nums[pos++] = 0;
        }
    }
    // Time Complexity: O(n)
    // Space Complexity: O(1)
}
