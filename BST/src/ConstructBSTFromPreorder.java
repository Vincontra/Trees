public class ConstructBSTFromPreorder {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){

        }
    }
    public static void main(String[] args) {
        // 8 5 1 7 10 12

    }
    public static TreeNode func(int arr[],int upBound,int i[]){
        if (i[0]==arr.length||arr[i[0]]>upBound){
            return null;
        }
        TreeNode node = new TreeNode(arr[i[0]]);
        i[0]++;
        node.left=func(arr, node.val,i);
        node.right=func(arr,upBound,i);
        return node;
    }
}
