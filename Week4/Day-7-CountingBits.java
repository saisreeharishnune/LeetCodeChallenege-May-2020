class Solution {
    public int[] countBits(int num) {
        if (num < 0)
            return new int[1];
        
        // allocate array incuding 0->num
        int[] countBitArray = new int[num + 1];
        
        // initial DP data
        countBitArray[0] = 0;
        
        for (int i = 1; i <= num; i++) {
            // if num is even, bit count is same as num / 2
            // if odd, bit count is same as (num / 2) + 1
            countBitArray[i] = countBitArray[i >> 1] + i % 2;
        }
        
        return countBitArray;

    }
}

class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        
        for(int i = 1; i <= num; i++) {
            result[i] = numberOfBits(i);
        }
        
        return result;
    }
    
    int numberOfBits(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}