class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        int oldColor = image[sr][sc];
        
        DFS(image, sr, sc, oldColor, newColor);
        
        return image;
    }
    
    private void DFS(int[][] image, int i, int j, int oldColor, int newColor) {
        
        if(i < 0 || j < 0 || i>= image.length || j>= image[0].length || image[i][j] == newColor) 
            return;
        
        if(image[i][j] == oldColor){
            image[i][j] = newColor;
            DFS(image, i+1, j, oldColor, newColor);
            DFS(image, i-1, j, oldColor, newColor);
            DFS(image, i, j+1, oldColor, newColor);
            DFS(image, i, j-1, oldColor, newColor);
        }
    }
}