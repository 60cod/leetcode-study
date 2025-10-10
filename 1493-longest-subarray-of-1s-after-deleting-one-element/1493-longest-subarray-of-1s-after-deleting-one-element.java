class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            // 0이 1개 초과되면 왼쪽 포인터 이동
            while (zeroCount > 1) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            // 한 개를 반드시 삭제해야 하므로 (right - left)
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}

/*
Time Complexity: O(n)
 - 슬라이딩 윈도우로 배열 한 번만 순회

Space Complexity: O(1)
 - 상수 변수만 사용
*/
