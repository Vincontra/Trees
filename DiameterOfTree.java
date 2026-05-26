public class DiameterOfTree {
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
//    static int diamter=0;
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(7);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.left.right.left=new TreeNode(5);
        root.left.right.right=new TreeNode(6);
        int diamter[]=new int[1];
        System.out.println("Before: "+diamter[0]);
        height(root,diamter);
        System.out.println("After:  "+diamter[0]);
    }
    public static int height(TreeNode root,int diamter[]){
        if (root==null){
            return 0;
        }
        int lh=height(root.left,diamter);
        int rh=height(root.right,diamter);
        diamter[0]=Math.max(diamter[0],lh+rh);
        return 1+Math.max(lh,rh);
    }
}
