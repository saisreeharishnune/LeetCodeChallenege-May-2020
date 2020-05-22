class Solution {
    public String frequencySort(String s) {
        if(s.isEmpty() || s.length()==0)
            return s;
        int[] map = new int[128];
        char[] cA = s.toCharArray();
        
        for(char c:cA)
            map[c]++;
        
        char[] result = new char[s.length()];
        for(int i=0;i<s.length();){
            int max = 0;
            int index = 0;
            for(int j = 0;j<128;j++){
                if(map[j]>max){
                    max = map[j];
                    index = j;
                }
            }
            while(map[index]>0){
                result[i++] = (char)index;
                map[index]--;
            }
        }
        return new String(result);
    }
}