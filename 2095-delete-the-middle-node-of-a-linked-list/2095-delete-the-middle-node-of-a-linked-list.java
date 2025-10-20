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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null; // 노드가 하나면 삭제 후 null 반환

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // fast가 끝에 도달할 때 slow는 중간 노드
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 중간 노드 삭제
        prev.next = slow.next;

        return head;
    }
}

/*
Time Complexity: O(n)
 - 리스트를 한 번 순회하여 중간 노드 탐색

Space Complexity: O(1)
 - 추가 공간 없이 포인터만 사용
*/
