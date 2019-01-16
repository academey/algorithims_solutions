// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
    ListNode<Integer> resultNode = null, currentNode = null;
    
    while(l1 != null && l2 != null) {
        if (l1.value <= l2.value) {
            if (resultNode == null) {
                resultNode = new ListNode<Integer>(l1.value);
                currentNode = resultNode;
            } else {
                currentNode.next = new ListNode<Integer>(l1.value);
                currentNode = currentNode.next;
            }
            l1 = l1.next;
        } else {
            if (resultNode == null) {
                resultNode = new ListNode<Integer>(l2.value);
                currentNode = resultNode;
            } else {
                currentNode.next = new ListNode<Integer>(l2.value);
                currentNode = currentNode.next;
            }
            l2 = l2.next;
        }
    }
    
    while(l1 != null) {
        if (resultNode == null) {
            resultNode = new ListNode<Integer>(l1.value);
            currentNode = resultNode;
        } else {
            currentNode.next = new ListNode<Integer>(l1.value);
            currentNode = currentNode.next;
        }
        l1 = l1.next;
    }
    
    while(l2 != null) {
        if (resultNode == null) {
            resultNode = new ListNode<Integer>(l2.value);
            currentNode = resultNode;
        } else {
            currentNode.next = new ListNode<Integer>(l2.value);
            currentNode = currentNode.next;
        }
        l2 = l2.next;
    }
    
    return resultNode;
}

// I can't use this function cause java pass actual parameter call by value.
// So If you want to refactor this code, you make reference manipulating function like ListNode<T>::append(ListNode<T>)
void appendListNode(ListNode<Integer> newNode, ListNode<Integer> resultNode, ListNode<Integer> currentNode) {
    if (resultNode == null) {
        resultNode = new ListNode<Integer>(newNode.value);
        currentNode = resultNode;
    } else {
        currentNode.next = new ListNode<Integer>(newNode.value);
        currentNode = currentNode.next;
    }
}
