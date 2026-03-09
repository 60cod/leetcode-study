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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        // fast를 n+1 만큼 먼저 이동
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // fast가 끝에 도달할 때까지 같이 이동
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 삭제
        slow.next = slow.next.next;

        return dummy.next;
    }
}

/*
시간 복잡도: O(n) - 리스트를 한 번 순회
공간 복잡도: O(1) - 추가 포인터 변수만 사용
*/