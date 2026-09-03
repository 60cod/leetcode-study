class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode less = lessDummy;
        ListNode greater = greaterDummy;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }

            head = head.next;
        }

        greater.next = null;
        less.next = greaterDummy.next;

        return lessDummy.next;
    }
}

// 시간 복잡도 - O(n), n은 연결 리스트의 노드 개수
// 공간 복잡도 - O(1)