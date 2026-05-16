class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];

        for (int i = n - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';

            for (int j = m - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';

                int sum = result[i + j + 1] + a * b;
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;

        while (index < result.length && result[index] == 0) {
            index++;
        }

        while (index < result.length) {
            sb.append(result[index++]);
        }

        return sb.toString();
    }
}

// 시간 복잡도 - O(n * m), n은 num1의 길이, m은 num2의 길이
// 공간 복잡도 - O(n + m)