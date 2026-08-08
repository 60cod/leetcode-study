class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int current = 0;
        int right = nums.length - 1;

        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, left, current);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
                right--;
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 시간 복잡도 - O(n), n은 배열 nums의 길이
// 공간 복잡도 - O(1)