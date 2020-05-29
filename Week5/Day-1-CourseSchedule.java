class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses ==0 || prerequisites.length ==0) return true;
        ArrayList[] graph = new ArrayList[numCourses];
        //populating the graph
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<Integer>();
        }
        //populating the prerequisites
        for(int i=0;i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
           if (!dfs(i,graph,visited)){
              return false;
           }   
        }
        return true;
    }
    
    private boolean dfs(int course,ArrayList[] children,int[] visited){
       // System.out.println("course"+course+"  visited[course]"+visited[course]);
        if (visited[course] == 1){
            return false;
        }
        visited[course] = 1;
        for(int i=0;i<children[course].size();i++){
            int val = (int)children[course].get(i);
           // System.out.println("val"+val+"  visited[val]"+visited[val]);
            if (visited[val] == 1) return false;
            if (visited[val] == 0 && !dfs(val,children,visited)){
                return false;
            }
        }
       visited[course] = 2;
        return true;
    }
}