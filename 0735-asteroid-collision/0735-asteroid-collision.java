class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!stack.isEmpty() && stack.peekLast() > 0 && asteroid < 0) {
                if (stack.peekLast() < -asteroid) {
                    stack.pollLast();
                    continue;
                } else if (stack.peekLast() == -asteroid) {
                    stack.pollLast();
                }
                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.addLast(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        int i = 0;
        for (int val : stack) {
            result[i++] = val;
        }
        return result;
    }
}
