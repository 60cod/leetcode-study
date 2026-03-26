class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1; // 고유 요소 카운터
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

// 시간 복잡도 - O(n), n은 배열 nums의 길이
// 공간 복잡도 - O(1)