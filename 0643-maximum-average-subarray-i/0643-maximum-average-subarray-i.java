class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // Step 1: 첫 k개의 합
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        
        double maxSum = sum;
        
        // Step 2: 슬라이딩 윈도우
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k]; // 윈도우 이동
            maxSum = Math.max(maxSum, sum);
        }
        
        // Step 3: 최대 평균 반환
        return maxSum / k;
        // Time Complexity: O(n)
        // Space Complexity: O(1)
    }
}
