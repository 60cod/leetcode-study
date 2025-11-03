import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions); // potion 배열 오름차순 정렬
        int m = potions.length;
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long spell = spells[i];
            // 이진 탐색: spell * potions[j] >= success 최소 인덱스 찾기
            int left = 0, right = m - 1, idx = m;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (spell * (long)potions[mid] >= success) {
                    idx = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = m - idx; // 성공하는 potion 개수
        }

        return result;
    }
}

/*
Time Complexity: O(m log m + n log m)
 - potions 정렬 O(m log m)
 - 각 spell마다 이진 탐색 O(log m) 수행 → n * log m

Space Complexity: O(1) extra
 - 결과 배열 제외, 추가 자료구조 사용 X
*/
