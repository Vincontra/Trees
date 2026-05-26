public class MaxPathSumInBinaryTrees {
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

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        int sum[]=new int[1];
        func(root,sum);
        System.out.println(sum[0]);
    }
    public static int func(TreeNode root,int sum[]){
        if (root==null){
            return 0;
        }
        int leftsum=func(root.left,sum);
        int ls=0;
        int rs=0;
        if(leftsum<0){
            ls=0;
        }else{
            ls=leftsum;
        }
        int rightsum=func(root.right,sum);
        if(rightsum<0){
            rs=0;
        }else{
            rs=rightsum;
        }
        sum[0]=Math.max(sum[0],ls+rs+root.val);
        return root.val+Math.max(ls,rs);
    }
}