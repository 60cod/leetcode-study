public class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;  // 행렬의 크기
        int count = 0;  // 일치하는 행과 열의 쌍 개수
        
        // 행과 열을 모두 비교하는 방법
        // 행은 고정하고, 열을 순차적으로 비교
        for (int i = 0; i < n; i++) {  // 행 반복
            for (int j = 0; j < n; j++) {  // 열 반복
                boolean match = true;  // 일치하는지 확인하는 flag
                // 해당 행과 열을 비교
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        match = false;  // 하나라도 다르면 일치하지 않음
                        break;
                    }
                }
                if (match) {  // 일치하면 카운트 증가
                    count++;
                }
            }
        }
        
        return count;
    }
}
