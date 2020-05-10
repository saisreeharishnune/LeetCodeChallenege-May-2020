class Solution {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int i =0;
        for(char c :s.toCharArray()){
            arr[c - 'a']++; 
        }
        for(char c : s.toCharArray()){
            if(arr[c -'a'] == 1)
                return i;
            i++;
        }
        return -1;
    }
}