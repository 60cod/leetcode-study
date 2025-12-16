class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0;              // 주식을 들고 있지 않을 때의 최대 이익
        int hold = -prices[0];     // 주식을 들고 있을 때의 최대 이익

        for (int i = 1; i < prices.length; i++) {
            // 주식을 팔거나 유지
            cash = Math.max(cash, hold + prices[i] - fee);
            // 주식을 사거나 유지
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
    // 시간 복잡도: O(n) - 가격 배열 1회 순회
    // 공간 복잡도: O(1) - 상수 공간 사용

}
