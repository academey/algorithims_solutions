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
boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
    Tree<Integer> current = t;
    return search(t, 0, s);
}

boolean search(Tree<Integer> t, int currentSum, int s) {
    if (t == null) {
        return false;
    }
    
    currentSum += t.value;
    if (t.left == null && t.right == null && currentSum == s) {
        return true;
    }
    
    return search(t.left, currentSum, s) || search(t.right, currentSum, s);
}hasPat