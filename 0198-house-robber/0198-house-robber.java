class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int prev2 = 0; // i-2까지 최대 금액
        int prev1 = nums[0]; // i-1까지 최대 금액

        for (int i = 1; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}

/*
Time Complexity: O(n)
 - 각 집마다 최대 금액 계산

Space Complexity: O(1)
 - 두 변수만 사용하여 DP 상태 유지
*/
