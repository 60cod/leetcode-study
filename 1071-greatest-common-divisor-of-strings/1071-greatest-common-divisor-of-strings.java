class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // 공통 문자열 존재 여부 체크
        if (!(str1 + str2).equals(str2 + str1)) return "";

        // 길이의 최대공약수 계산
        int lenGcd = gcd(str1.length(), str2.length());

        // GCD 길이만큼 잘라서 반환
        return str1.substring(0, lenGcd);
    }

    // 유클리드 호제법으로 길이 GCD 계산
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Time Complexity
    // 문자열 덧셈 & 비교: O(n + m)
    // GCD: O(log(min(n,m))) → 무시 가능
    // substring: O(min(n,m)) ≤ O(n+m)
    // total -> O(n + m)

    // Space Complexity: 문자열 덧셈 저장 → O(n+m)
}
