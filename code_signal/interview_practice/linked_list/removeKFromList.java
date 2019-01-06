// Definition for singly-linked list:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
   ListNode<Integer> x = l;
   ListNode<Integer> prev = null;
   while(x != null) {
      ListNode<Integer> x_next = x.next;
      if(x.value == k) {
         if(prev != null) {
            prev.next = x_next;
         } else {
            l = x_next;
         }
      } else {
         prev = x;
      }
      x = x_next;
   }

   return l;
}
