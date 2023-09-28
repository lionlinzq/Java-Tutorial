package com.lzq.algo;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // ListNode listNode = getLastNode();
        Solution solution = new Solution();
        System.out.println(solution.eliminateMaximum(new int[]{1, 1, 2, 3}, new int[]{1, 1, 1, 1}));
    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        return 1;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = current;
            current = current.next;
        }
        return head;
    }

    public static ListNode getLastNode() {
        ListNode e = new ListNode(5, null);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        return a;
    }


    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            /*
              dist[i] - 1) / speed[i] + 1;
              上面语句其实等于：
              1.没有余数： dist[i] / speed[i]
              2.存在余数： dist[i] / speed[i] + 1
             */
            arrivalTimes[i] = (dist[i] - 1) / speed[i] + 1;
        }
        Arrays.sort(arrivalTimes);
        for (int i = 0; i < n; i++) {
            if (arrivalTimes[i] <= i) {
                return i;
            }
        }
        return n;
    }

    public int maxDistToClosest(int[] seats) {
        int res = 0;
        int left = 0;
        while (left < seats.length && seats[left] == 0) {
            left++;
        }
        res = left;
        while (left < seats.length) {
            int right = left + 1;
            while (right < seats.length && seats[right] == 0) {
                right++;
            }
            if (right == seats.length) {
                res = Math.max(res, right - left - 1);
            } else {
                res = Math.max(res, (right - left) / 2);
            }
            left = right;
        }
        return res;
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        TreeNode left = mergeTrees(root1.left, root2.left);
        TreeNode right = mergeTrees(root1.right, root2.right);
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }
}
