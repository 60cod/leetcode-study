class Solution {
    public double myPow(double x, int n) {
        long exp = n;

        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        double result = 1.0;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result *= x;
            }

            x *= x;
            exp >>= 1;
        }

        return result;
    }
}

// 시간 복잡도 - O(log n), n은 지수의 절댓값
// 공간 복잡도 - O(1)