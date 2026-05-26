import java.util.*;

public class PrintAllNodesAtDisK {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            this.left= null;
            this.right=null;
        }
    }

    public static void main(String[] args){
        ArrayList<Integer>l1=new ArrayList<>();

    }
    public static void func(TreeNode root,TreeNode target,ArrayList<Integer>l1,int k){

        //logic:
        // we cant go back or cant do backward traversal so first we need to do that backward pointers as well
        // for that we will do level order to just have that backward pointers
        // if the target node is give or we may have to search depends upon the question
        // here it is given we will start from it and radially goes each unit dis
        // along with that we will mark as visited since it might possible we will again try to go to the same node which is
        // already visited to avoid that i will use hashset
        // for storing parents we will use hashmap
        // we will keep doing this until our dis==k and whatever nodes at that moment present inside queue will be our answer

        HashMap<TreeNode,TreeNode>hashMap = new HashMap<>();
        Queue<TreeNode>q1=new LinkedList<>();
        q1.add(root);
        while (!q1.isEmpty()){
            int s=q1.size();
            for (int i=0;i<s;i++){
                TreeNode curr=q1.remove();
                if (curr.left!=null){
                    q1.add(curr.left);
                    hashMap.put(curr.left,curr);
                }
                if (curr.right!=null){
                    q1.add(curr.right);
                    hashMap.put(curr.right,curr);
                }
            }
        }

        int dis=0;
        q1.add(target);
        HashSet<TreeNode> seen = new HashSet<>();
        seen.add(target);

        while(!q1.isEmpty() && dis<k){
            int size=q1.size();   // process whole level
            for(int i=0;i<size;i++){
                TreeNode curr=q1.remove();
                if(curr.left!=null && !seen.contains(curr.left)){
                    seen.add(curr.left);
                    q1.add(curr.left);
                }
                if(curr.right!=null && !seen.contains(curr.right)){
                    seen.add(curr.right);
                    q1.add(curr.right);
                }
                if(hashMap.containsKey(curr) && !seen.contains(hashMap.get(curr))){
                    seen.add(hashMap.get(curr));
                    q1.add(hashMap.get(curr));
                }
            }
            dis++;
        }
        while(!q1.isEmpty()){
            l1.add(q1.remove().val);
        }
    }
}
