import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Integer[] numsWrapper = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsWrapper, Collections.reverseOrder());
        return numsWrapper[k - 1];
    }
}