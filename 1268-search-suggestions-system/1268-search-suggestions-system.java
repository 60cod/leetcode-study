import java.util.*;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        int n = products.length;
        int left = 0, right = n - 1;

        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);

            // left가 현재 prefix를 만족하지 않으면 증가
            while (left <= right && (products[left].length() <= i || products[left].charAt(i) != c)) {
                left++;
            }
            // right가 현재 prefix를 만족하지 않으면 감소
            while (left <= right && (products[right].length() <= i || products[right].charAt(i) != c)) {
                right--;
            }

            // left..right 범위에서 최대 3개를 취함
            List<String> list = new ArrayList<>();
            for (int k = 0; k < 3 && left + k <= right; k++) {
                list.add(products[left + k]);
            }
            ans.add(list);
        }

        return ans;
    }
}

/*
Time Complexity: O(m log m + m + L)
 - m = products.length, L = searchWord.length()
 - 정렬 O(m log m)
 - left/right 포인터는 전체 과정에서 최대 m번씩 이동 -> O(m)
 - 각 접두사 단계에서 결과로 최대 3개만 수집 -> 추가 O(L)

Space Complexity: O(1) extra (출력 제외)
 - 정렬을 위한 내부 작업(및 출력 리스트 ans)을 제외하면 추가 자료구조 사용 없음
 - 출력 크기는 O(min(3, m) * L)
*/
