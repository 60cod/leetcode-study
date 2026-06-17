import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];

        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
            numbers.add(i);
        }

        k--; // 0-indexed

        StringBuilder sb = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int index = k / factorial[i - 1];

            sb.append(numbers.get(index));
            numbers.remove(index);

            k %= factorial[i - 1];
        }

        return sb.toString();
    }
}

// 시간 복잡도 - O(n^2), n은 숫자의 개수
// 공간 복잡도 - O(n)