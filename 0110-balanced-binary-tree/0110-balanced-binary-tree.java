class Solution {
    static boolean ans;
    public int levels(TreeNode root){
        if(root==null) return 0;
        int a=levels(root.left);
        int b=levels(root.right);
        int diff=Math.abs(a-b);
        if(diff>1) ans=false;
        return 1+Math.max(a,b);
    }
    // conditions for balanced treee:
    // |levelOfLeft-levelOfRight|<=1
    
    public boolean isBalanced(TreeNode root) {
       ans=true;
       levels(root);
       return ans;
       

    }
}