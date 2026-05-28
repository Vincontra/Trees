import java.util.*;
public class BSTIterator {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;

        }
    }

    public static void main(String[] args) {

    }

        static Stack<TreeNode>s1;

        public BSTIterator(TreeNode root) {
            s1=new Stack<>();
            while(root!=null){
                s1.push(root);
                root=root.left;
            }
        }

        public int next() {
            TreeNode curr=s1.pop();
            int val=curr.val;
            curr=curr.right;
            while(curr!=null){
                s1.push(curr);
                curr=curr.left;
            }
            return val;

        }

        public boolean hasNext() {
            return s1.size()!=0;
        }


}
//TC:
// for each call O(1);
// overall dekha jaye to for each node at max one time
// matlab O(N)
// as har ek node is operated at least once

// SC:
// at max height ke baraber hi nodes rahenge kisi bhi samay or usse kam hi
// so O(H)



