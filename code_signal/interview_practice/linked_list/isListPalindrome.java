
/*
    Hint : O(n) transversing same check can be at midian node.
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
    ListNode<Integer> y = median.next;
    ListNode<Integer> prevNode = median;
    ListNode<Integer> nextNode = y.next;
    while(nextNode != null && nextNode.next != null) {
        nextNode = nextNode.next;
        y.next = prevNode;
        prevNode = y;
        y = nextNode;
    }
    x = l;
    y = nextNode;

    while(x != null && y != null && x.next != y.next) {
        if (!x.value.equals(y.value)) {
            isListPalindrome = false;
        }
        x = x.next;
        y = y.next;
    }

    return isListPalindrome;
}
