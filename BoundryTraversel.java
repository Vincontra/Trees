import java.util.ArrayList;
import java.util.Stack;

public class BoundryTraversel {
    // anticlockwise
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args) {


        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.right.right=new TreeNode(9);
        root.right.right.right=new TreeNode(100);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);

        // antoclockwise matlab left left left then leaf nodes then right right right lekin in reverse order
        // logic:
        // keep going left until left exist then right again left like this way till leaf
        // all leaf node must be stored using inorder traversal // lekin isme level order kaam nhi krega//
        // aasan bhasha me kuch bhi kro just needed that leaf nodes all together
        // uske badd right right until no right same as left lekin last me we need reverse of this order

        ArrayList<Integer>l1=new ArrayList<>();
        leftBoundry(root,l1);
        LeafNodes(root,l1);
        Stack<Integer>s1=new Stack<>();
        RightBoundry(root.right,s1);
        while (!s1.isEmpty()){
            l1.add(s1.pop());
        }
        System.out.println("Printing the Boundry nodes");
        for (int i=0;i<l1.size();i++){
            System.out.print(l1.get(i)+" ");
        }
    }
    public static void leftBoundry(TreeNode root, ArrayList<Integer>l1){
        if (root==null){
            return;
        }
        if (root.left==null&&root.right==null){
            return;
        }
        l1.add(root.val);
        if (root.left!=null){
            leftBoundry(root.left,l1);
        }
        else{
            leftBoundry(root.right,l1);
        }
    }
    public static void LeafNodes(TreeNode root,ArrayList<Integer>l1) {
        if (root==null){
            return;
        }
        if (root.left==null&&root.right==null){
            l1.add(root.val);
        }
        LeafNodes(root.left,l1);
        LeafNodes(root.right,l1);
    }
    public static void RightBoundry(TreeNode root,Stack<Integer>s1) {
        if (root==null){
            return;
        }
        if (root.left==null&&root.right==null){
            return;
        }
        s1.push(root.val);
        if (root.right!=null){
            RightBoundry(root.right,s1);
        }
        else{
            RightBoundry(root.left,s1);
        }
    }
}
