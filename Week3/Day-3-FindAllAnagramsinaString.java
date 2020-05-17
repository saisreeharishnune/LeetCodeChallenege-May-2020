class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len = p.length()-1;
        int[] lookup = new int[26];
        int[] dp = new int[26];
        List<Integer> result = new ArrayList<>();
        for(char c : p.toCharArray()){
            lookup[c-'a']++;
        }
        
        for(int i=0;i<s.length();i++){
            dp[s.charAt(i)-'a']++;
            if(i>=len){
                if(checkAnagram(lookup,dp)){
                result.add(i-len);
                }
                dp[s.charAt(i-len)-'a']--;
            }
        }
        return result;
    }
    
    private boolean checkAnagram(int[] lookup, int[] dp){
        for(int i=0;i<26;i++){
            if(lookup[i]!=dp[i]){
                return false;
            }
        }
        return true;
    }
}