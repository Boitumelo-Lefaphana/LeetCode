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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // Step 1: Find the a-1-th node (prevA) and the b+1-th node (afterB)
        ListNode prevA = list1;
        for (int i = 1; i < a; i++) {
            prevA = prevA.next;
        }
        
        ListNode afterB = prevA;
        for (int i = a; i <= b + 1; i++) {
            afterB = afterB.next;
        }
        
        // Step 2: Connect prevA.next to the head of list2
        prevA.next = list2;
        
        // Step 3: Traverse to the end of list2
        ListNode endOfList2 = list2;
        while (endOfList2.next != null) {
            endOfList2 = endOfList2.next;
        }
        
        // Step 4: Connect the end of list2 to afterB
        endOfList2.next = afterB;
        
        // Step 5: Return the modified list1
        return list1;
    }
}
