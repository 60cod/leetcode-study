class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(0, rooms, visited);

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] visited) {
        if (visited[room]) return;
        visited[room] = true;

        for (int key : rooms.get(room)) {
            dfs(key, rooms, visited);
        }
    }
}

/**
 * Time Complexity: O(n + k)
 *  - n: 방 수, k: 모든 키의 총 개수
 *  - 각 방과 키를 최대 한 번씩만 방문
 *
 * Space Complexity: O(n)
 *  - visited 배열 + 재귀 스택 깊이 최대 n
 */
