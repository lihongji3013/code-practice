package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: hongji
 * @Date: 2021-11-16 18:39
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 */

public class ReversLinkList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> startList = new ArrayList();

        ArrayList<Integer> resultList = new ArrayList();

        ListNode currentNode = listNode;
        while (currentNode != null) {
            startList.add(currentNode.val);
            currentNode = currentNode.next;
        }
        for (int i = startList.size() - 1; i >= 0; i--) {
            resultList.add(startList.get(i));
        }
        return resultList;
    }

    public static ArrayList<Integer> printListByStackFromTailToHead(ListNode listNode) {
        ArrayList<Integer> resultList = new ArrayList();
        Stack<Integer> stack = new Stack<>();

        ListNode currentNode = listNode;

        while (currentNode !=null){
            stack.push(listNode.val);
            currentNode = currentNode.next;
        }
        while (!stack.empty()){
            resultList.add(stack.pop());
        }
        return resultList;
    }
    public static void main(String[] args) {
        ListNode nodeSta = new ListNode(15);    //创建首节点
        ListNode nextNode = new ListNode(20);                     //声明一个变量用来在移动过程中指向当前节点
        nextNode=nodeSta;

        System.out.println(printListFromTailToHead(nodeSta));

    }
}
