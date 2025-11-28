import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        // 그래프 구성: 
        //   정방향: a -> b (원래 방향)
        //   역방향: b -> a (반대 방향)
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] c : connections) {
            int a = c[0];
            int b = c[1];
            // 정방향: cost = 1 (바꿔야 한다)
            graph.get(a).add(new int[]{b, 1});
            // 역방향: cost = 0 (바꿀 필요 없음)
            graph.get(b).add(new int[]{a, 0});
        }

        // BFS/DFS로 0에서 시작해서 탐색
        int result = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int[] next : graph.get(cur)) {
                int node = next[0];
                int cost = next[1];
                if (!visited[node]) {
                    result += cost;
                    visited[node] = true;
                    q.offer(node);
                }
            }
        }

        return result;
    }
    // 시간 복잡도: O(n) — 각 노드는 한 번씩만 방문
    // 공간 복잡도: O(n) — 그래프 저장 및 visited 배열

}
