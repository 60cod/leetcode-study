class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            // 0의 개수가 k를 초과하면 왼쪽 포인터 이동
            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
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
