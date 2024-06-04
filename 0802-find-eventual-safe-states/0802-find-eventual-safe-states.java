class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        
        int n = graph.length;
        List<List<Integer>> rG = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            rG.add(new ArrayList<>());
        }
        
        
        // fill reverse graph and count indeg
        int[] indegree = new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int nbr : graph[i]){
                rG.get(nbr).add(i);
                indegree[i]++;
            }
        }
        
        
        // Initialize the queue with terminal nodes
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        
        // Process the nodes
        List<Integer> safeNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            
            for (int neighbor : rG.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        // Sort the safe nodes in ascending order
        Collections.sort(safeNodes);
        return safeNodes;
        
    }
}