class Solution {
    public String removeKdigits(String num, int k) {
        if (num==null || k<=0) return num;
        char[] c=num.toCharArray();
		int right=0;
		int left=0;
		while(right<c.length){
            if(left==0){
                if(c[right]=='0') 
                    right++;
                else  
                    c[left++]=c[right++];
            }
            else if(k>0 && c[left-1]>c[right]){
				left--;
				k--;
			}
            else {
				c[left++]=c[right++];
			}
           
		}
		while (k>0) {
			left--;
            k--;
		}
		return left<=0?"0":new String(c, 0, left);
    }
}