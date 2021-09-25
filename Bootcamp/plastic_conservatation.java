import java.io.*;
import java.util.*;
import java.math.*;

class Solution {

   static class Position {
      int x, y;
      Position(int x_pos, int y_pos) { x = x_pos; y = y_pos ; }
      Position(Position pos) { x = pos.x ; y = pos.y ; }
   }
   
   static class Edge {
      Position p1, p2;
      int index1, index2; // indices into original Position[] array
      double length;
      Edge(Position pos1, int idx1, Position pos2, int idx2) {
          p1 = pos1;
	      p2 = pos2;
	      index1 = idx1;
	      index2 = idx2;
	      double xsquared = (p1.x - p2.x) * (p1.x - p2.x) ;
	      double ysquared = (p1.y - p2.y) * (p1.y - p2.y) ;
	      length = Math.sqrt(xsquared + ysquared) ;
      }
   }

   static class Vertex {
      int v;         // vertex number: its index in the original Position[] array
      Position pos;  // the position of this vertex
      Edge[] edges;  // the edges leaving this vertex
      Edge min_edge; // available for use by MST algorithm
      double min_length;
      int data;      // available for use by MST algorithm

      Vertex(Position[] positions, int index) {
    	 v = index;
    	 pos = positions[index];
    	 edges = new Edge[positions.length];
    	 min_edge = null;
    	 min_length = Double.POSITIVE_INFINITY;
      }

      // initialize edges from each vertex to all other vertices
       // you can ignore this function if you use make_graph() to convert
       // the array given to min_cost() into a graph
      static void set_edges(Vertex[] vertices) {
    	 if (vertices.length < 1) return;
    	 for (int i = 0; i < vertices.length; i++) {
             for (int j = 0; j < vertices.length; j++) {
	           Edge e ;
	           if (vertices[j].edges != null && vertices[j].edges[i] != null)
		          e = vertices[j].edges[i];
	           else if (j != i)
		          e = new Edge(vertices[i].pos,i,vertices[j].pos,j);
	           else
		          e = null;
	           vertices[i].edges[j] = e;
             }
         }
      }
      
   }

   // initialize edge graph, which is the complete graph between all positions
   static Vertex[] make_graph(Position[] positions) {
      if (positions == null) return new Vertex[0];
      Vertex[] vertices = new Vertex[positions.length];
      for (int i = 0 ; i < positions.length; i++) {
          vertices[i] = new Vertex(positions,i) ;
      }
      Vertex.set_edges(vertices);
      return vertices;
   }


   // fill in min_edge fields
   static void find_min_edges(Vertex[] vertex) {
      if (vertex == null) return;
      for (int i = 0 ; i < vertex.length; i++) {
          double min_length = vertex[i].min_length;
          Edge min_edge = null;
          for(int j = 0 ; j < vertex[i].edges.length ; j++){
              if(vertex[i].edges[j].length < min_length){
                  min_length = vertex[i].edges[j].length;
                  min_edge = vertex[i].edges[j];
              }
          }
          vertex[i].min_length = min_length;
          vertex[i].min_edge = min_edge;
      }
   }
   
   static double min_cost1(Position[] positions) {
       for(int i = 0 ; i < positions.length ; i++){
           System.out.format("%d, %d \n", positions[i].x, positions[i].y );
       }
       
    //    System.out.format(" Expected: %f ", min_cost2(positions));
       
       if(positions == null) return 0.0;
       int N = positions.length;
       Set<Integer> visited = new HashSet<>();
       Vertex[] vertex = make_graph(positions);
       
       visited.add(0);
       double result = 0.0;
       
       while( visited.size() < N ){
           double min_length = Double.POSITIVE_INFINITY;
           Edge min_edge = null;
           for(int vi : visited){
               Vertex v = vertex[vi];
               for(int j = 0 ; j < v.edges.length ; j++){
                   if( v.edges[j] == null ) continue;

                   if(visited.contains(v.edges[j].index2) && visited.contains(v.edges[j].index1)){
                    //    System.out.format(" position : [%d,%d] adready in visited \n", positions[v.edges[j].index2].x,positions[v.edges[j].index2].y);
                       continue;
                   }
                   
                   if(v.edges[j].length < min_length){
                       min_length = v.edges[j].length;
                       min_edge = v.edges[j];
                   }
               }
           }
           result += min_length;
           visited.add(min_edge.index1);
           visited.add(min_edge.index2);
       }
       return result;
   }
   
    static class PointNode{
        public double cost;
        public int index;

        public PointNode(double cost,int index){
            this.cost = cost;
            this.index = index;
        }

        public String toString(){
            return "cost: " + cost + " index: " + index;
        }
    }

    // static double[][] distances = new double[][];
    
    static double distance(Position p1, Position p2) {
        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y-p2.y,2));
    }
    
    // static get distance
    
    static double min_cost(Position[] positions) {
        if(positions == null) return 0.0;
        
        // Vertex[] vertex = make_graph(positions);
        
        PriorityQueue<PointNode> pq = new PriorityQueue(new Comparator<PointNode>(){
            @Override
            public int compare(PointNode p1, PointNode p2){
                if (p1.cost == p2.cost) return 0;
                return (p1.cost-p2.cost) < 0 ? -1 : 1;
            }
        });

        int N = positions.length;
        Map<Integer, List<PointNode>> adj = new HashMap<>();

        pq.add(new PointNode(0.0 , 0));
        double res = 0;
        Set<Integer> toVisit = new HashSet<>();
        for(int i = 0 ; i < N ; i++){
            toVisit.add(i);
        }

        while(toVisit.size() > 0){
            PointNode cur = pq.poll();
            if(!toVisit.contains(cur.index)) continue; // already visited
            res += cur.cost;
            toVisit.remove(cur.index);
            
            for(int nodeIdx : toVisit){
                pq.add(new PointNode( distance(positions[cur.index] , positions[nodeIdx]) , nodeIdx ));
            }
        }

        return res;
    }
    

   public static void main(String[] args) throws IOException {