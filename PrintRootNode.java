import java.util.ArrayList;
import java.util.Scanner;

public class PrintRootNode {
    static TreeNode root;
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static void main(String[] args) {
        root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
//        ArrayList<Integer>l1=new ArrayList<>();
//        func(root,l1,6);
//        for (int i=0;i<l1.size();i++){
//            System.out.println(l1.get(i));
//        }
    }
    public static boolean func(TreeNode root,ArrayList<Integer>l1,int tar){
        if (root==null){
            return false;
        }
        l1.add(root.val);
        if (root.val==tar){
            return true;
        }
        if (func(root.left,l1,tar)||func(root.right,l1,tar)){
            return true;
        }
        l1.remove(l1.size()-1);
        return false;
    }
}
