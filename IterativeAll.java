import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Date;
import java.util.Stack;

public class IterativeAll {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }
    public static void main(String args[]) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);

//        ArrayList<Integer>l1=new ArrayList<>();
//        Preorder(root,l1);
//        Inorder(root,l1);
//        PostOrder2(root,l1);
//        for (int i=0;i<l1.size();i++){
//            System.out.print(l1.get(i)+" ");
//        }

        ArrayList<Integer>l1=new ArrayList<>();
        ArrayList<Integer>l2=new ArrayList<>();
        ArrayList<Integer>l3=new ArrayList<>();
        AllInOne(l1,l2,l3,root);

        for (int i=0;i<l1.size();i++){
            System.out.print(l1.get(i)+" ");
        }
        System.out.println();

        for (int i=0;i<l2.size();i++){
            System.out.print(l2.get(i)+" ");
        }
        System.out.println();

        for (int i=0;i<l3.size();i++){
            System.out.print(l3.get(i)+" ");
        }

    }
    public static void Preorder(TreeNode root, ArrayList<Integer>l1) {
        if (root==null) {
            return;
        }
        // always put root
        // pop it while doing so put its right and then left as LIFO as root left right
        // do this till empty
        Stack<TreeNode>s1=new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode curr=s1.pop();
            l1.add(curr.val);
            if (curr.right!=null){
                s1.push(curr.right);
            }
            if (curr.left!=null){
                s1.push(curr.left);
            }
        }
    }
    public static void Inorder(TreeNode root,ArrayList<Integer>l1){
        if (root==null){
            return;
        }
        Stack<TreeNode>s1=new Stack<>();
        TreeNode node=root;
        while (true){
            if (node!=null){
                s1.push(node);
                node=node.left;
            }
            else{
                if (s1.isEmpty()){
                    break;
                }else {
                    node=s1.pop();
                    l1.add(node.val);
                    node=node.right;
                }
            }
        }
    }
    public static void PostOrder(TreeNode root,ArrayList<Integer>l1){
        // using 2 stacks
        if (root==null){
            return;
        }
        Stack<TreeNode>s1=new Stack<>();
        Stack<Integer>s2=new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()){
            TreeNode curr=s1.pop();
            s2.push(curr.val);
            if (curr.left!=null){
                s1.push(curr.left);
            }
            if (curr.right!=null){
                s1.push(curr.right);
            }
        }
        while (!s2.isEmpty()){
            l1.add(s2.pop());
        }
    }
    // using single stack
//    Go as left as possible and push nodes.
//    Peek at the top node.
//    If it has a right child that hasn't been processed yet → move to the right.
//    Otherwise process the node and pop it.

    public static void PostOrder2(TreeNode root,ArrayList<Integer>l1){
        if (root==null){
            return;
        }
        Stack<TreeNode>s1=new Stack<>();
        TreeNode curr=root;
        TreeNode last=null;
        while (curr!=null||!s1.isEmpty()){

            while (curr!=null){
                s1.push(curr);
                curr=curr.left;
            }

            TreeNode top=s1.peek();
            if (top.right!=null&&top.right!=last){
                curr=top.right;
            }
            else{
                l1.add(top.val);
                last=s1.pop();
            }
        }
    }
    public static void AllInOne(ArrayList<Integer>preorder,ArrayList<Integer>inorder,ArrayList<Integer>postorder,TreeNode root){
        Stack<Pair>s1=new Stack<>();
        s1.push(new Pair(root,1));
        if (root==null){
            return;
        }
        while (!s1.isEmpty()){
            Pair it=s1.pop();
            if (it.val==1){
                preorder.add(it.root.val);
                it.val++;
                s1.push(it);

                if (it.root.left!=null){
                    s1.push(new Pair(it.root.left,1));
                }
            }
            else if (it.val==2){
                inorder.add(it.root.val);
                it.val++;
                s1.push(it);

                if (it.root.right!=null){
                    s1.push(new Pair(it.root.right,1));
                }

            }else{
                postorder.add(it.root.val);

            }
        }




    }
    static class Pair{
        TreeNode root;
        int val;
        public Pair(TreeNode root,int val){
            this.root=root;
            this.val=val;
        }
    }
}
