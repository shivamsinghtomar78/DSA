class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int mx=1;
        int [] dp=new int[n];
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                 if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                mx=Math.max(mx,dp[i]);
                 }
            }
        }
        return mx;
    }
}