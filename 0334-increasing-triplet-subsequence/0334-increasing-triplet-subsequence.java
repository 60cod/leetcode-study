class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n <= first) {
                // 가장 작은 값 갱신
                first = n;
            } else if (n <= second) {
                // 두 번째 작은 값 갱신
                second = n;
            } else {
                // n > second라면, first < second < n 조건 만족
                return true;
            }
        }

        return false;
    }
}