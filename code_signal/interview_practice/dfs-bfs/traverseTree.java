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

int[] traverseTree(Tree<Integer> t) {
    Queue<Tree<Integer>> queue = new LinkedList<Tree<Integer>>();
    ArrayList<Integer> result = new ArrayList<>();
    if (t != null) {
        queue.add(t);
    }
    
    while(!queue.isEmpty()) {
        Tree<Integer> currentTree = queue.poll();
        result.add(currentTree.value);
        
        if (currentTree.left != null) {
            queue.add(currentTree.left);
        }
        if (currentTree.right != null) {
            queue.add(currentTree.right);
        }
    }
    
    return result.stream().mapToInt(i -> i).toArray();

}
