class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        
        return i == s.length();
        // Time Complexity: O(|t|)
        // Space Complexity: O(1)
        // Follow up: 기본 문제는 투 포인터로 O(|t|)에 풀 수 있음. 하지만 s가 많이 들어오는 경우 매번 O(|t|)로 검사하면 비효율적임. -> t를 한 번 전처리해서 각 문자의 인덱스를 저장해 두고, subsequence 검사할 때는 s의 각 문자를 이진 탐색으로 찾아가면 O(|s| log |t|)에 처리할 수 있음.
    }
}
