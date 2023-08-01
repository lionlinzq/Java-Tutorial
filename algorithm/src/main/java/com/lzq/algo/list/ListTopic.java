package com.lzq.algo.list;

import lombok.extern.slf4j.Slf4j;

/**
 * 链表的问题
 *
 * @author lionlinzq
 * @date 2023/7/31 15:01
 */
@Slf4j
public class ListTopic {
    public static void main(String[] args) {
        ListTopic listTopic = new ListTopic();

        ListNode e = new ListNode(5, null);
        ListNode d = new ListNode(4, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        ListNode reverseList = listTopic.reverseList2(a);
        System.out.println(reverseList);
    }

    /**
     * 143.重新排序列表
     *
     * @param head 头
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int count = 0;

    }

    /**
     * 反转链表(迭代法)
     *
     * @param head 头
     * @return {@link ListNode}
     */
    public ListNode reverseList1(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * 反转链表(递归法)
     *
     * @param head 头
     * @return {@link ListNode}
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}



