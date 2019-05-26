package com.sunrise.leetcode.easy;

import java.util.List;

/**
 * @description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * eg:
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @date: 2019/5/26 23:02
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class MergeTwoSortedListsSolution {
    /**
     * @description:
     * @param:   null
     * @return: 取出两个链表中的第一个元素，对比大小，小元素的放在前面节点，然后取小元素的下一个对比另一个链表中的元素
     *          当任意一个链表为空时，另外一个非空链表的最后一个元素设置为最末节点
     * @auther: sunriseme
     * @date: 2019/5/26 23:29
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rspHead=new ListNode(0);
        ListNode rsp=rspHead;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                rspHead.next=l1;
                l1=l1.next;
            }else{
                rspHead.next=l2;
                l2=l2.next;
            }
            rspHead=rspHead.next;
        }
        if(l1==null){
            rspHead.next=l2;
        }else{
            rspHead.next=l1;
        }
        return rsp.next;

    }

    /**
     * @description:  插队法
     * @param:   null
     * @return:
     * @auther: sunriseme
     * @date: 2019/5/26 23:30
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l2 == null) return l1;
        if (l1 == null) return l2;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode start = l1.val < l2.val ? l1 : l2;
        do {
            if (p2.val <= p1.val) {
                while (p2.next != null && p2.next.val <= p1.val) {
                    p2 = p2.next;
                }
                l2 = p2.next;
                p2.next = p1;
            } else {
                while (p1.next != null && p1.next.val < p2.val) {
                    p1 = p1.next;
                }
                l2 = p2.next;
                p2.next = p1.next;
                p1.next = p2;
            }
            p2 = l2;
        } while (p2 != null);
        return start;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode node = mergeTwoLists(listNode, listNode2);

        while (node.next!=null){
            int value = node.val;
            node = node.next;
            System.out.println(node.val);
        }

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
