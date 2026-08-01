import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String dir : path.split("/")) {
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }

            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(dir);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append("/").append(stack.removeFirst());
        }

        return sb.toString();
    }
}

// 시간 복잡도 - O(n), n은 문자열 path의 길이
// 공간 복잡도 - O(n)