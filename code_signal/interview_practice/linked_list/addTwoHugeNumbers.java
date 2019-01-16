// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
    ListNode<Integer> lastNodeA = reverseListNode(a);
    ListNode<Integer> lastNodeB = reverseListNode(b);
    ListNode<Integer> resultNode = null;
    ListNode<Integer> currentNode = null;
    Integer sum = 0, remainder = 0, quotient = 0;
    while(lastNodeA != null && lastNodeB != null) {
        sum = lastNodeA.value + lastNodeB.value + quotient;
        remainder = sum % 10000;
        quotient = sum / 10000;
        if (resultNode == null) {
            resultNode = new ListNode<Integer>(remainder);
            currentNode = resultNode;
        } else {
            currentNode.next = new ListNode<Integer>(remainder);
            currentNode = currentNode.next;
        }
        lastNodeA = lastNodeA.next;
        lastNodeB = lastNodeB.next;
    }
    
    while(lastNodeA != null) {
        sum = lastNodeA.value + quotient;
        remainder = sum % 10000;
        quotient = sum / 10000;
        if (resultNode == null) {
            resultNode = new ListNode<Integer>(remainder);
            currentNode = resultNode;
        } else {
            currentNode.next = new ListNode<Integer>(remainder);
            currentNode = currentNode.next;
        }
        
        lastNodeA = lastNodeA.next;
    }
    
    while(lastNodeB != null) {
        sum = lastNodeB.value + quotient;
        remainder = sum % 10000;
        quotient = sum / 10000;

        if (resultNode == null) {
            resultNode = new ListNode<Integer>(remainder);
            currentNode = resultNode;
        } else {
            currentNode.next = new ListNode<Integer>(remainder);
            currentNode = currentNode.next;
        }
        
        lastNodeB = lastNodeB.next;
    }
    
    if (quotient > 0) {
        currentNode.next = new ListNode<Integer>(quotient);
        currentNode = currentNode.next;
    }
    
    
    return reverseListNode(resultNode);
}

ListNode<Integer> reverseListNode(ListNode<Integer> a) {
    ListNode<Integer> prevA = a;
    ListNode<Integer> currentA = a.next;
    ListNode<Integer> nextA = null;
    prevA.next = null;
    while(currentA != null) {
        nextA = currentA.next;
        currentA.next = prevA;
        
        prevA = currentA;
        currentA = nextA;
    }
    
    return prevA;
}
