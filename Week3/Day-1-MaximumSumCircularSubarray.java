//2ms Execution Time
class Solution {
    public int maxSubarraySumCircular(int[] array) {
        int acc = 0;
        int max1 = kadane(array);
        for(int i = 0; i < array.length; i++) {
            acc += array[i];
            array[i] = -array[i];
        }
        int min = kadane(array);
        int max2 = acc + min;
        if(max2 == 0) {
            return max1;
        }
        return Math.max(max1, max2);
    }
    public int kadane(int[] array) {
        int maxTillI = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            maxTillI = Math.max(maxTillI+array[i], array[i]);
            max = Math.max(max, maxTillI);
        }
        return max;
    }
}

//3ms Execution Time
class Solution {
     public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = -30000, curMax = 0, minSum = 30000, curMin = 0;
        for (int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}

//4ms Execution Time
class Solution {
public static int maxSubarraySumCircular(int[] A) {
    int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    int sum1 = 0, sum2 = 0, total = 0;
    for(int x : A) {
        if(sum1<0){
            sum1 = 0;
        }
        sum1 += x;
        max = Math.max(max, sum1);
        if(sum2>0){
            sum2 = 0;
        }
        sum2 += x;
        min = Math.min(min, sum2);
        total += x;
    }
    return max > 0 ? Math.max(max, total - min) : max;
  }
}