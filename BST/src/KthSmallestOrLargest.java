public class KthSmallestOrLargest {
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
    public int kthSmallest(TreeNode root, int k) {
            int cnt[]=new int[1];
            boolean arr[]=new boolean[1];
            func(root,k,cnt,arr);
            return cnt[0];
    }
    public static void func(TreeNode root,int k,int cnt[],boolean arr[]){
            if(root==null){
                return;
            }
            func(root.left,k,cnt,arr);
            if(arr[0]){
                return;
            }
            cnt[0]++;
            if(cnt[0]==k){
                cnt[0]=root.val;
                arr[0]=true;
                return;
            }
            func(root.right,k,cnt,arr);
    }
    // kth largest nothing but right ki call first
    // then root
    // then left
    //done


}
