class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search for a peak
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Peak is on the right side
                left = mid + 1;
            } else {
                // Peak is on the left side (including mid)
                right = mid;
            }
        }

        return left;
    }
    // 시간 복잡도: O(log n) - 이진 탐색 수행
    // 공간 복잡도: O(1) - 추가 메모리 사용 없음
}
