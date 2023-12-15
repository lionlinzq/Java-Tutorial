package com.lzq.algo.list;

import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * @author: lzq
 * @since: 2023-09-04
 **/
public class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
    private static TreeNode createTree(int index, Integer[] integers) {
        if (index > integers.length - 1 || integers[index] == null) {
            return null;
        }
        TreeNode root = new TreeNode(integers[index]);
        root.left = createTree(2 * index + 1, integers);
        root.right = createTree(2 * index + 2, integers);
        return root;
    }

    // 层序遍历
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            // arrayList.add(cur.val);
            System.out.println(cur.val);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        System.out.print(arrayList);
    }

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};
        TreeNode treeNode = createTree(0, integers);
        levelOrder(treeNode);

        String night = "999";

        System.out.println(night + 1);
    }

}
