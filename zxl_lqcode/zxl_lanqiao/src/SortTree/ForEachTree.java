package SortTree;


import java.util.*;

//树的前中后三种遍历的非递归方法
public class ForEachTree {
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);  // 访问根节点

            // 右子节点先入栈（后出）
            if (node.right != null) {
                stack.push(node.right);
            }
            // 左子节点后入栈（先出）
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
    //中序遍历,重要，常用于二叉搜索树
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // 一路向左入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 弹出访问，转向右子树
            cur = stack.pop();
            result.add(cur.val);  // 访问根节点
            cur = cur.right;      // 处理右子树
        }

        return result;
    }


    //后续遍历
    // 方法一：前序变形 + 反转（推荐，简洁易懂）
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);  // 头插法，相当于最后反转

            // 注意：这里先左后右，因为用的是头插
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return result;
    }
    // 方法二：经典双栈法
    public List<Integer> postorderTraversalTwoStacks(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack1 = new ArrayDeque<>();
        Deque<TreeNode> stack2 = new ArrayDeque<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);  // 中转栈

            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
