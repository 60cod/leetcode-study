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
    public int pairSum(ListNode head) {
        // 1. 중간 노드 찾기 (slow-fast 포인터)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. 후반부 역순(reverse)
        ListNode second = reverseList(slow);

        // 3. 전반부와 후반부를 순회하며 twin sum 계산
        int maxSum = 0;
        ListNode first = head;
        while (second != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return maxSum;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

/*
Time Complexity: O(n)
 - 리스트 한 번 순회로 중간 탐색, 한 번 역순, 한 번 twin sum 계산

Space Complexity: O(1)
 - 추가 자료구조 사용 없이 in-place 역순 처리
*/
