class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // 1. 뒤에서부터 감소가 깨지는 지점 찾기
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. 교환할 값 찾기
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // 3. 뒤집기
        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
}

// 시간 복잡도 - O(n), n은 배열 nums의 길이
// 공간 복잡도 - O(1)