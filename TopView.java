import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopView {
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
    static class Pair{
        int val;
        TreeNode node;
        public Pair(int val,TreeNode node){
            this.val=val;
            this.node=node;
        }
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        root.left.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);

        // ans is 4 2 1 3 7

        // logic is :
        // verticle line similar to verticle order me jo hoti hai wo
        // uss line pr anewala first node can be visible from top
        // doubt ye ho sakt ki boundry hi print krte
        // lekin nhi boundry me kuch nodes aise bhi honge that will not be seen from top lekin
        // still part of boumdry
        // we will use level order

        HashMap<Integer,Integer>hm=new HashMap<>();
        Queue<Pair>q1=new LinkedList<>();
        q1.add(new Pair(0,root));
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        while (!q1.isEmpty()){
            Pair curr=q1.remove();
            int val=curr.val;
            TreeNode node = curr.node;

            if (!hm.containsKey(val)){
                hm.put(val, node.val);
            }
            if (node.left!=null){
                q1.add(new Pair(val-1,node.left));
            }
            if (node.right!=null){
                q1.add(new Pair(val+1,node.right));
            }
            min=Math.min(min,val);
            max=Math.max(max,val);
        }
        for (int i=min;i<=max;i++){
            System.out.print(hm.get(i)+" ");
        }
    }
}
