class Solution {
    public boolean isPalindrome(int x) {
        // 음수이거나 0으로 끝나는 수는 팰린드롬이 될 수 없음 (단, 0 제외)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // 뒤 절반만 뒤집기
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // 짝수 자리수: x == reversedHalf
        // 홀수 자리수: x == reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}

/*
시간 복잡도: O(log10(n)) - 자릿수의 절반만큼 반복
공간 복잡도: O(1) - 추가 변수만 사용
*/