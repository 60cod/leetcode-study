class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {findFirst(nums, target), findLast(nums, target)};
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            if (nums[mid] == target) res = mid;
        }

        return res;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int res = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (nums[mid] == target) res = mid;
        }

        return res;
    }
}

// 시간 복잡도 - O(log n), n은 배열 nums의 길이
// 공간 복잡도 - O(1)