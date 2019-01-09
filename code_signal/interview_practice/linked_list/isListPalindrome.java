/*
    Hint : O(n) transversing same check can be at midian node.
    And, you have to consider the middle one's next should be null because check end.
*/

// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean isListPalindrome(ListNode<Integer> l) {
    boolean isListPalindrome = true;
    ListNode<Integer> x = l;
    
    if (x == null || x.next == null) {
        return true;
    }
    ListNode<Integer> median = l;
    while(x != null && x.next != null && x.next.next != null) {
        median = median.next;
        x = x.next.next;
    }

    ListNode<Integer> prevNode = median;
    ListNode<Integer> y = median.next;
    ListNode<Integer> nextNode = y.next;
    
    prevNode.next = null;
    
    while(y != null) {
        y.next = prevNode;
        prevNode = y;
        if (nextNode == null) {
            break;
        }
        y = nextNode;
        nextNode = nextNode.next;
    }
    
    x = l;
    while(x != null && y != null) {
        if (!x.value.equals(y.value)) {
            isListPalindrome = false;
            break;
        }
        if (x.next == null || y.next == null) {
            break;
        }
        x = x.next;
        y = y.next;
    }
    
    return isListPalindrome;
}
