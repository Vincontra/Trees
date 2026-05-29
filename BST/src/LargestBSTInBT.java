// CONTRA SIGNING OFFF!!! WILL MEET YOU SOON IN NEXT PART STAY TUNED!!
//public class LargestBSTInBT {
//    //1373. Maximum Sum BST in Binary Tree LC
//
//}
//
//class Solution {
//
//    static int ans;
//
//    static class Node{
//        int sum;
//        int min;
//        int max;
//        public Node(int min,int max,int sum){
//            this.min=min;
//            this.max=max;
//            this.sum=sum;
//        }
//    }
//
//    public static Node postorder(TreeNode root){
//        if(root==null){
//            return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
//        }
//        Node leftS=postorder(root.left);
//        Node rightS=postorder(root.right);
//        if(leftS.max<root.val&&root.val<rightS.min){
//            int currs=leftS.sum+root.val+rightS.sum;
//            ans=Math.max(ans,currs);
//            return new Node(Math.min(leftS.min,root.val),Math.max(root.val,rightS.max),currs);
//        }
//        return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(leftS.sum,rightS.sum));
//    }
//
//    public int maxSumBST(TreeNode root) {
//        ans=0;
//        Node curr=postorder(root);
//        return ans;
//    }
//}

// done by me this is actually little bit diff q as we need to calc sum here and not count which is ther in original q
// concept is same
// if you do not actually update the global sum here ---> ans var
// then you may get wrong ans
// try to separate Node.sum and ans as there might be possiblity that two diff subtree valid as well as invalid might update the
// possible max and final ans may be get less than expected
// Done with BT and BST
//
