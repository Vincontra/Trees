import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomUp {
    static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val=val;
            this.left= null;
            this.right=null;
        }
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        ArrayList<Integer>l1=new ArrayList<>();
        func(root,l1);

    }
    public static void func(Node root,ArrayList<Integer>l1){
        Queue<Pair>q1=new LinkedList<>();
        q1.add(new Pair(0,root));
        HashMap<Integer,Integer>hashMap = new HashMap<>();
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        while(!q1.isEmpty()){
            Pair curr=q1.remove();
            int val=curr.val;
            Node node=curr.node;
            hashMap.put(val,node.val);
            min=Math.min(min,val);
            max=Math.max(max,val);
            if (node.left!=null){
                q1.add(new Pair(val-1,node.left));
            }
            if (node.right!=null){
                q1.add(new Pair(val+1,node.right));
            }
        }
        for (int i=min;i<=max;i++){
            l1.add(hashMap.get(i));
        }
    }
    static class Pair{
        int val;
        Node node;
        public Pair(int val,Node node){
            this.val=val;
            this.node=node;
        }
    }
}
