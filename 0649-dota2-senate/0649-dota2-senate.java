import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        // 각 당의 의원 인덱스를 큐에 저장
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') radiant.add(i);
            else dire.add(i);
        }

        // 라운드 진행
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // 인덱스가 더 작은 쪽이 먼저 행동 (상대방을 밴하고 자신은 다음 라운드로 이동)
            if (rIndex < dIndex) {
                radiant.add(rIndex + n); // 다음 라운드로 이동
            } else {
                dire.add(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}

/*
Time Complexity: O(n)
 - 각 의원이 최대 한 번 밴되거나 다음 라운드로 이동하므로 O(n) 내에 종료

Space Complexity: O(n)
 - 두 큐에 최대 n개의 인덱스 저장 가능
*/
