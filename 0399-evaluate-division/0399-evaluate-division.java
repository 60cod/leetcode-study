import java.util.*;

public class Solution {
    // 그래프 구조: 각 노드는 인접 노드와 해당 간선 가중치(비율)을 Map으로 표현
    private Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // 그래프 구성
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, value);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / value);
        }

        // 쿼리 처리
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else if (start.equals(end)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(start, end, 1.0, visited);
            }
        }

        return results;
    }

    private double dfs(String current, String target, double accProduct, Set<String> visited) {
        if (current.equals(target)) {
            return accProduct;
        }

        visited.add(current);

        Map<String, Double> neighbors = graph.get(current);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String nextNode = entry.getKey();
            double value = entry.getValue();

            if (!visited.contains(nextNode)) {
                double result = dfs(nextNode, target, accProduct * value, visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}
