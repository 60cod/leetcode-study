class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // If the last element in the stack is negative, there's no need to check for collisions.
            // This is because both rocks are moving left, so they can't explode.
            // That's why we only check for collisions when the top of the stack is positive.

            // 1. Remove
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                // Since we know which is negative, no need to use 'Math.abs()'.
                if (stack.peek() < -asteroid) {
                    stack.pop();
                    // Keep comparing
                    continue;
                }
                else if (stack.peek() == -asteroid) {
                    stack.pop();
                    // Both exploded. (Terminate the loop and reset asteroid)
                    asteroid = 0;
                }
                break;
            }

            // 2. Add (After all the smaller, exploded asteroids had been removed)
            if (stack.isEmpty() || stack.peek() < 0 || asteroid > 0) {
                if (asteroid != 0) {
                    stack.push(asteroid);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }
        return result;
    }
}