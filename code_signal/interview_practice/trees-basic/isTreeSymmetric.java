//
// Definition for binary tree:
// class Tree<T> {
//   Tree(T x) {
//     value = x;
//   }
//   T value;
//   Tree<T> left;
//   Tree<T> right;
// }
boolean isTreeSymmetric(Tree<Integer> t) {
    if (t == null) {
        return true;
    }
    return recursiveCheck(t.left, t.right);
}

boolean recursiveCheck(Tree<Integer> left, Tree<Integer> right) {
    if ((left == null) && (right == null)) {
        return true;
    }
    if ((left == null) || (right == null)) {
        return false;
    }
    
    return left.value.equals(right.value) && recursiveCheck(left.left, right.right) && recursiveCheck(left.right, right.left);
}