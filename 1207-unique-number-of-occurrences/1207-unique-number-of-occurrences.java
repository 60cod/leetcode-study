import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // 등장 횟수 계산
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> occurrences = new HashSet<>();
        for (int freq : countMap.values()) {
            if (!occurrences.add(freq)) { // 중복되면 false
                return false;
            }
        }
        
        return true;
    }
}
