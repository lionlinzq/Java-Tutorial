package com.lzq.algo.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树主题
 *
 * @author lin
 * @date 2023/09/10
 */
public class BinaryTreeTopic {

    private TreeNode root;

    public static void main(String[] args) {
        BinaryTreeTopic binaryTreeTopic = new BinaryTreeTopic();

    }

    public BinaryTreeTopic() {
        this.root = buildBinaryTree();
    }

    /**
     * 构建二叉树
     *
     * @return {@link TreeNode}
     */
    private TreeNode buildBinaryTree() {
        TreeNode four = new TreeNode(4, null, null);
        TreeNode five = new TreeNode(5, null, null);
        TreeNode two = new TreeNode(2, four, five);

        TreeNode six = new TreeNode(6, null, null);
        TreeNode seven = new TreeNode(7, null, null);
        TreeNode three = new TreeNode(3, six, seven);

        TreeNode one = new TreeNode(1, two, three);

        return one;
    }

    /**
     * 二叉树前序遍历
     * 递归实现
     *
     * @param root 根部
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> preorderTraversalByRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    /**
     * 二叉树前序遍历
     *
     * @param root 根部
     * @param list 列表
     */
    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    /**
     * 二叉树前序遍历
     *
     * @param root 根部
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    /**
     * 中序遍历，递归
     *
     * @param root 根部
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> inorderTraversalByRecursion(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    /**
     * 中序
     *
     * @param root 根部
     * @param list 列表
     */
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 中序遍历
     *
     * @param root 根部
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

    /**
     * 后序遍历
     * 前序遍历时 中左右
     * 后续遍历时 左右中
     * 所以也可以 中右左再对结果取反
     *
     * @param root 根部
     * @return {@link List}<{@link Integer}>
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    /**
     * 层序遍历
     *
     * @param root 根部
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            list.add(level);
        }
        return list;
    }

    /**
     * 递归层序遍历
     *
     * @param root 根部
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> levelOrderByRecursion(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelDfs(root, list, 0);
        return list;
    }


    /**
     * 层次遍历DFS
     *
     * @param root   根部
     * @param result 结果
     * @param depth  深度
     */
    public void levelDfs(TreeNode root, List<List<Integer>> result, Integer depth) {
        if (root == null) {
            return;
        }
        if (result.size() == depth) {
            result.add(new ArrayList<Integer>());
        }

        result.get(depth).add(root.val);
        levelDfs(root.left, result, depth);
        levelDfs(root.right, result, depth);
    }

    /**
     * 从底部层序遍历上来
     *
     * @param root 根部
     * @return {@link List}<{@link List}<{@link Integer}>>
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        return list;
    }


}
