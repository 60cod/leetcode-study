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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head;              // 홀수 노드 포인터
        ListNode even = head.next;        // 짝수 노드 포인터
        ListNode evenHead = even;         // 짝수 리스트의 시작점 저장

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead; // 홀수 리스트 끝에 짝수 리스트 연결
        return head;
    }
}

/*
Time Complexity: O(n)
 - 리스트를 한 번 순회하며 노드 연결 조정

Space Complexity: O(1)
 - 추가 공간 없이 포인터만 사용
*/
