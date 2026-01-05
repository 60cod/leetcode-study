class Solution {
    public int minFlips(int a, int b, int c) {
        int flips = 0;

        // 최대 30비트(10^9 < 2^30)까지 확인
        for (int i = 0; i < 31; i++) {
            int bitA = (a >> i) & 1;
            int bitB = (b >> i) & 1;
            int bitC = (c >> i) & 1;

            if (bitC == 0) {
                // a | b 가 0이어야 함 -> a, b 모두 0
                flips += bitA + bitB;
            } else {
                // bitC == 1 -> a 또는 b 중 하나는 1이어야 함
                if (bitA == 0 && bitB == 0) {
                    flips += 1;
                }
            }
        }

        return flips;
    }
    // 시간 복잡도: O(1) - 고정 비트 수(31비트) 반복
    // 공간 복잡도: O(1) - 추가 공간 사용 없음
}
