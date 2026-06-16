public class DeleteLeavesWithValEqaulToK1325 {
    public static void main(String[] args) {
        Solution solution=new Solution();

    }

}

class Solution1 {
    static class TreeNode{ // most optimized one again done by me
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(){

        }

    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return func(root,target);
    }
    public static TreeNode func(TreeNode root,int target){
        if(root==null){
            return null;
        }
        root.left=func(root.left,target);
        root.right=func(root.right,target);
        if(root.left==null&&root.right==null&&root.val==target){
            return null;
        }
        return root;
    }
}
class Solution2 {
    static class TreeNode{ // most optimized one again done by me
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(){

        }

    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {  // brute one done by me

        // we will pass tree each time to check that whether there exist some node which has value==target
        // if so delete that
        // at worst n*n will be tc;
        // as traversing n and passing it n(like all nodes equal to target)

        boolean check[]=new boolean[1];
        do{
            check[0]=false;
            preorder(root,target,check);
        }
        while(check[0]);

        if(root.val==target&&root.left==null&&root.right==null){
            return null;
        }
        return root;
    }

    public static void preorder(TreeNode root,int target,boolean check[]){
        if(root==null){
            return;
        }
        if(root.left!=null&&root.left.left==null&&root.left.right==null&&root.left.val==target){
            root.left=null;
            check[0]=true;
        }
        if(root.right!=null&&root.right.left==null&&root.right.right==null&&root.right.val==target){
            root.right=null;
            check[0]=true;
        }
        preorder(root.left,target,check);
        preorder(root.right,target,check);
    }

}
class Solution {
    static class TreeNode{ // most optimized one again done by me
        TreeNode left;
        TreeNode right;
        int val;
        public TreeNode(){

        }

    }
    public TreeNode removeLeafNodes(TreeNode root, int target) { //// best one done by me

        // we will pass tree each time to check that whether there exist some node which has value==target
        // if so delete that
        // at worst n*n will be tc;
        // as traversing n and passing it n(like all nodes equal to target)

        boolean check[]=new boolean[1];
        do{
            check[0]=false;
            preorder(root,target,check);
        }
        while(check[0]);

        if(root.val==target&&root.left==null&&root.right==null){  //
            return null;
        }
        return root;
    }

    public static void preorder(TreeNode root,int target,boolean check[]){
        if(root==null){
            return;
        }
        preorder(root.left,target,check);
        if(root.left!=null&&root.left.left==null&&root.left.right==null&&root.left.val==target){
            root.left=null;
            check[0]=true;
        }
        if(root.right!=null&&root.right.left==null&&root.right.right==null&&root.right.val==target){
            root.right=null;
            check[0]=true;
        }
        preorder(root.right,target,check);
    }

}