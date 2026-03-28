class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // val이 아닌 요소의 개수
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

// 시간 복잡도 - O(n), n은 배열 nums의 길이
// 공간 복잡도 - O(1)