import java.util.*;

public class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상하좌우
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0}); // {x, y, steps}
        maze[entrance[0]][entrance[1]] = '+'; // 방문 처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], steps = current[2];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && maze[nx][ny] == '.') {
                    if (nx == 0 || nx == m - 1 || ny == 0 || ny == n - 1) {
                        return steps + 1;
                    }
                    maze[nx][ny] = '+'; // 방문 처리
                    queue.offer(new int[]{nx, ny, steps + 1});
                }
            }
        }

        return -1; // 출구를 찾을 수 없음
    }
}
