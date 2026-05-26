class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 전치
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 각 행 뒤집기
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }
}

// 시간 복잡도 - O(n^2), n은 행렬 matrix의 한 변 길이
// 공간 복잡도 - O(1)