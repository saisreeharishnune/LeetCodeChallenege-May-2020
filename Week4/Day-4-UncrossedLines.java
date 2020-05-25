class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int mx[] = new int[B.length];
        int cm[] = new int[B.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                cm[j] = Math.max((j == 0 ? 0 : cm[j - 1]), mx[j]);
            }
            //System.out.println(Arrays.toString(cm) + " sa");
            for(int j = 0; j < B.length; j++){
                if(A[i] == B[j]){
                    mx[j] = Math.max((j == 0 ? 0 : cm[j - 1]) + 1, mx[j]);
                }
            }
           // System.out.println(Arrays.toString(mx));
        }
        int ans = 0;
        for(int i = 0; i < B.length; i++){
            ans = Math.max(ans, mx[i]);
        }
        return ans;
    }
}