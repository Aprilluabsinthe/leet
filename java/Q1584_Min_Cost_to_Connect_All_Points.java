class PointNode{
    public int cost;
    public int index;

    public PointNode(int cost,int index){
        this.cost = cost;
        this.index = index;
    }

    public String toString(){
        return "cost: " + cost + " index: " + index;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points == null) return 0;
        
        PriorityQueue<PointNode> pq = new PriorityQueue(new Comparator<PointNode>(){
            @Override
            public int compare(PointNode p1, PointNode p2){
                return p1.cost-p2.cost;
            }
        });

        int N = points.length;
        Map<Integer, List<PointNode>> adj = new HashMap<>();

        for (int i = 0 ; i < N ; i++ ){
            for(int j = i+1 ; j < N ;j++){
                int cost = Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);

                List<PointNode> list_i = adj.getOrDefault( i, new LinkedList<PointNode>());
                list_i.add(new PointNode(cost,j));
                adj.put( i , list_i );

                List<PointNode> list_j = adj.getOrDefault( j, new LinkedList<PointNode>());
                list_j.add(new PointNode(cost,i));
                adj.put( j , list_j );
            }
        }

        pq.add(new PointNode(0,0));
        int res = 0;
        Set<Integer> visited = new HashSet<>();

        while(visited.size() < N){
            PointNode cur = pq.poll();
            if(visited.contains(cur.index)) continue;
            res += cur.cost;
            visited.add(cur.index);
            if(adj.get(cur.index)!=null){
                for( PointNode neib : adj.get(cur.index)){
                    if(visited.contains(neib.index)) continue;
                    pq.add(neib);
                }
            }
            
        }

        return res;
    }

}