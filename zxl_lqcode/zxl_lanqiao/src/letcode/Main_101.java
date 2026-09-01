package letcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
//力扣101题
class Main_101 {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<TreeNode> levl = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // 叶子节点可以为null
                if(node.left==null) {
                    levl.offerLast(new TreeNode(Integer.MAX_VALUE));
                }else {
                    queue.offer(node.left);
                    levl.offerLast(node.left);
                }
                if(node.right==null){
                    levl.offerLast(new TreeNode(Integer.MAX_VALUE));
                }else {
                    queue.offer(node.right);
                    levl.offerLast(node.right);
                }

            }
            // 判断是否对称
            int lSize = levl.size();
            for (int i = 0; i < lSize/ 2; i++) {
                if (levl.pollFirst().val != levl.pollLast().val) {
                    return false;
                }
            }

        }
        return true;

    }
}