 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 탐색할 노드 없거나, 둘 중 하나 찾은 경우
            return root;
        }        
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        // 양쪽에서 노드를 찾으면 현재 root가 LCA
        if (leftNode != null && rightNode != null) {
            return root;
        }
        // 한쪽에서만 노드를 찾으면 그 노드가 LCA
        return leftNode != null ? leftNode : rightNode;
    }
}