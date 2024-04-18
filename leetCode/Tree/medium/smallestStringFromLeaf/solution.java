// class Solution {
//     public ArrayList dfs(TreeNode node) {
//         if (node.left == null && node.right == null) {
//             ArrayList<Integer> arrL= new ArrayList<>();
//             arrL.add(node.val);
//             return arrL;
//         } else if (node.left == null) {
//             ArrayList<Integer> arrL = dfs(node.right);
//             arrL.add(node.val);
//             return arrL;
//         } else if (node.right == null) {
//             ArrayList<Integer> arrL = dfs(node.left);
//             arrL.add(node.val);
//             return arrL;
//         } else {
//             ArrayList<Integer> arrLeft = dfs(node.left);
//             ArrayList<Integer> arrRight = dfs(node.right);
//             arrLeft.add(node.val);
//             arrRight.add(node.val);
//             return findShorter(arrLeft, arrRight);
//         }
//     }
//     // find lexicographically shorter of two arrays when recursing the tree.
//     public ArrayList findShorter(ArrayList<Integer> curr, ArrayList<Integer> other) {
//         int len_c = curr.size();
//         int len_o = other.size();
//         int smallest = len_c;
        
//         if (len_c < len_o) {
//            smallest = len_c;
//         } else if (len_o< len_c) {
//             smallest = len_o;
//         } 
//         for (int i=0; i< smallest; i++) {
//             if (curr.get(i) < other.get(i)) {
//                 return curr;
//             } else if (other.get(i) < curr.get(i)) {
//                 return other;
//             } else {
//                 continue;
//             }
//         }
//         return len_c<= len_o ? curr : other;
        
//     }
//     public String smallestFromLeaf(TreeNode root) {
//         ArrayList<Integer> smallest = dfs(root);
//         String result = "";
//         for (int j =0; j<smallest.size(); j++) {
//             char c = (char) (97 + smallest.get(j));
//             result = result + c;
//         }
//         return result;
//     }
// }
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        StringBuilder smallest = new StringBuilder();
        dfs(root, new StringBuilder(), smallest);
        return smallest.toString();
    }
    
    private void dfs(TreeNode node, StringBuilder path, StringBuilder smallest) {
        if (node == null) return;
        
        // Append current node's character to the path
        path.append((char)('a' + node.val));
        
        // If it's a leaf node, compare and update smallest
        if (node.left == null && node.right == null) {
            String currentString = path.reverse().toString();
            if (smallest.length() == 0 || currentString.compareTo(smallest.toString()) < 0) {
                smallest.setLength(0);
                smallest.append(currentString);
            }
            path.reverse(); // backtrack by reversing again
        }
        
        // Recursively traverse left and right subtrees
        dfs(node.left, path, smallest);
        dfs(node.right, path, smallest);
        
        // Backtrack: remove the current node's character from the path
        path.setLength(path.length() - 1);
    }
}
//smallest is outer scoped value that os changed by the dfs function.