class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        int len = points.length;
        int left = 0;
        int right = len - 1;
        
        while(left <= right){
            int partitionIndex = partition(points,left,right);
            if(partitionIndex == K){
                break;
            }
            if(partitionIndex < K){
                left = partitionIndex + 1;
            }else{
                right = partitionIndex - 1;
            }
        }
        
        return Arrays.copyOfRange(points,0,K);
    }
    
    public int partition(int[][] points,int left,int right){
        int[] pivot = points[left];
        
        while(left < right){            
            while(left < right && compare(points[right],pivot) <= 0) right--;
            points[left] = points[right];
            while(left < right && compare(points[left],pivot) >= 0) left++;
            points[right] = points[left];
        }
        points[left] = pivot;
        
        return left;
    }
    
    public int compare(int[] point1,int[] point2){
        return (point2[1] * point2[1] + point2[0] * point2[0]) - point1[1] * point1[1] - point1[0] * point1[0];
    }
}