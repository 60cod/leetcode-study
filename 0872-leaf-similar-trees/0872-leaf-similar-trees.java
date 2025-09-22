import java.util.*;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        
        // 두 리스트를 비교해서 같으면 true, 다르면 false
        return leaves1.equals(leaves2);
    }
    
    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            // 각 트리에서 리프 노드만 순서대로 리스트에 저장
            leaves.add(node.val);
        } else {
            getLeaves(node.left, leaves);
            getLeaves(node.right, leaves);
        }
    }
}
