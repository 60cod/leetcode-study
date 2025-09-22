class Solution {
    public ListNode reverseList(ListNode head) {
        // Linked List + 포인터 조작
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next; // 다음 노드 저장
            curr.next = prev;              // 현재 노드 뒤집기
            prev = curr;                   // prev 이동
            curr = nextTemp;               // curr 이동
        }
        
        return prev; // 새로운 head
        // Complexity: O(n) time, O(1) space
    }
}
