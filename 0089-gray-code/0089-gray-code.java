import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        int size = 1 << n;

        for (int i = 0; i < size; i++) {
            result.add(i ^ (i >> 1));
        }

        return result;
    }
}

// 시간 복잡도 - O(2^n), n은 비트 수
// 공간 복잡도 - O(2^n), 반환 리스트를 제외한 추가 공간은 O(1)