import java.util.Stack;

public class FlattenBinTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

    }

    public static void main(String[] args) {

    }
    public static void func(TreeNode root){
        // using stack
        Stack<TreeNode>s1=new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode curr=s1.pop();
            if (curr.right!=null){
                s1.push(curr.right);
            }
            if (curr.left!=null){
                s1.push(curr.left);
            }
            if (!s1.isEmpty()){
                curr.right=s1.peek();
            }
            curr.left=null;
        }

    }

}
