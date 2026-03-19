/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // swap
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // 다음 쌍으로 이동
            prev = first;
        }

        return dummy.next;
    }
}

/*
시간 복잡도: O(n) - 리스트를 한 번 순회
공간 복잡도: O(1) - 추가 포인터만 사용
*/