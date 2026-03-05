class Solution {
    public String intToRoman(int num) {
        // 숫자 값과 로마자 매핑 (큰 값부터 작은 값 순서)
        int[] values =    {1000, 900, 500, 400, 100, 90,  50,  40, 10, 9,  5, 4, 1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(romans[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}

/*
시간 복잡도: O(1) - 최대 3999까지 반복, 상수 범위
공간 복잡도: O(1) - 상수 크기 배열과 StringBuilder 사용
*/