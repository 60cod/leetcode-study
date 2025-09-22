class RecentCounter {

    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.add(t); // 새 요청 추가

        // 3000ms 이전 요청 제거
        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size(); // 남은 요청 수 반환
    }
    // Time complexity: O(n)
}