//import javax.swing.tree.TreeNode;
//public class CeilAndFloor {
//
//    // Lc 2476
//    // worst case we may have time complexity which is O(height*queries)
//    // skew treee me we have height n which can be upto 10^5
//    // so even though the function i wrote has tc as logN
//    // they wont work in case of skew
//    // i guess better would be inorder se array and then uspr binary search that would be nlogn in worst and not n*n
//
//    static class TreeNode{
//        int val;
//        TreeNode left;
//        TreeNode right;
//        public TreeNode(int val){
//            this.val=val;
//            this.left=null;
//            this.right=null;
//        }
//    }
//
//    public static void main(String[] args) {
//
//    }
//    public static int ceil(TreeNode root,int key){
//        int ans=-1;
//        while (root!=null){
//            if (root.val==key){
//                ans= root.val;
//                return ans;
//            }
//            else if (root.val>key){
//                ans=root.val;
//                root=root.left;
//            }
//            else{
//                root=root.right;
//            }
//        }
//        return ans;
//    }
//    public static int floor(TreeNode root,int key){
//        int ans=-1;
//        while (root!=null){
//            if (root.val==key){
//                ans= root.val;
//                return ans;
//            }
//            else if (root.val<key){
//                ans=root.val;
//                root=root.right;
//            }
//            else{
//                root=root.left;
//            }
//        }
//        return ans;
//    }
//}

//class Solution {
//    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
//        ArrayList<Integer>in=new ArrayList<>();
//        func(root,in);
//        List<List<Integer>>ans = new ArrayList<>();
//        for(int i=0;i<queries.size();i++){
//            int key=queries.get(i);
//            List<Integer>l1=new ArrayList<>();
//            l1.add(floor(in,key));
//            l1.add(ceil(in,key));
//            ans.add(l1);
//        }
//        return ans;
//    }
//    public static void func(TreeNode root, ArrayList<Integer> inorder) {
//        if(root == null) {
//            return;
//        }
//        func(root.left, inorder);
//        inorder.add(root.val);
//        func(root.right, inorder);
//    }
//
//    public static int floor(ArrayList<Integer> inorder, int key) {
//        int low=0;
//        int high=inorder.size()-1;
//        int ans=-1;
//        while(low<=high){
//            int mid=low+(high-low)/2;
//            if(inorder.get(mid)==key){
//                return inorder.get(mid);
//            }
//            else if(inorder.get(mid)<key) {
//                ans=inorder.get(mid);
//                low=mid+1;
//            }
//            else {
//                high=mid-1;
//            }
//        }
//        return ans;
//    }
//
//    public static int ceil(ArrayList<Integer> inorder, int key) {
//        int low=0;
//        int high=inorder.size()-1;
//        int ans=-1;
//        while(low<=high){
//            int mid=low+(high-low)/2;
//            if(inorder.get(mid)==key){
//                return inorder.get(mid);
//            }
//            else if(inorder.get(mid)>key) {
//                ans=inorder.get(mid);
//                high=mid-1;
//            }
//            else{
//                low=mid+1;
//            }
//        }
//        return ans;
//    }
//}
