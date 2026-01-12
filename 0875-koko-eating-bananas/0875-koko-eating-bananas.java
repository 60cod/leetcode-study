class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // 최대 pile 크기 탐색
        for (int p : piles) {
            right = Math.max(right, p);
        }

        // k에 대한 이분 탐색
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;      // 더 느린 속도 시도
            } else {
                left = mid + 1;   // 속도 증가 필요
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;

        for (int p : piles) {
            // ceil(p / k)
            hours += (p + k - 1) / k;
            if (hours > h) return false;
        }

        return true;
    }
    // 시간 복잡도: O(n log M)
    //   - n: piles 길이
    //   - M: piles의 최대값
    // 공간 복잡도: O(1) - 추가 자료구조 사용 없음
}
