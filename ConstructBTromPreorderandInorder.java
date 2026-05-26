import java.util.*;
public class ConstructBTromPreorderandInorder {

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
            HashMap<Integer,Integer>hm=new HashMap<>();
            for(int i=0;i<inorder.length;i++){
                hm.put(inorder[i],i);
            }
            TreeNode root=func(preorder,inorder,0,preorder.length-1,0,inorder.length-1,hm);
            return root;
    }
        public static TreeNode func(int pre[],int in[],int pstr,int pend,int instr,int inend,HashMap<Integer,Integer>hm){

            if(pstr>pend||instr>inend){
                return null;
            }
            TreeNode root=new TreeNode(pre[pstr]);
            int idx=hm.get(pre[pstr]);
            int kitnebache=idx-instr;
            root.left=func(pre,in,pstr+1,pstr+kitnebache,instr,idx-1,hm);
            root.right=func(pre,in,pstr+kitnebache+1,pend,idx+1,inend,hm);
            return root;
    }
}
