class Solution {
    static  int maxDia;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia=0;
        levels(root);
        return maxDia;
    }
    public int levels(TreeNode root){
        if(root==null) return 0;
        int a=levels(root.left);
        int b=levels(root.right);
        int myDia=a+b;
        maxDia=Math.max(maxDia,myDia);
        return 1+Math.max(a,b);
    }
}