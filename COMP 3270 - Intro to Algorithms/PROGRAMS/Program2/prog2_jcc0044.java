import java.util.Scanner;
import java.util.LinkedList;

/**
 * @author John Carroll
 * @version 12-04-2014
 */

public class prog2 {
   int MAX_VALUE = Integer.MAX_VALUE;
   int WHITE = 1; 
   int GRAY = 2; 
   int BLACK = 3;
   Scanner scanner = new Scanner(System.in);
   Graph G = new Graph(); 

   public static void main(String args[]) { 
      new prog2().run();
   } 

   public void BFS(Graph G, Node s) {
      for(Node u: G.nodeList){                      //1 for each vertex u 2 G:V  fsg
         u.color = WHITE;                           //2 u.color = WHITE;
         u.d = MAX_VALUE;                           //3 u.d(distance) = infinity
         u.pi = null;                               //4 u.pi = NIL
      }
      s.color = GRAY;                               //5 s.color = GRAY
      s.d = 0;                                      //6 s.d = 0;
      s.pi = null;                                  //7 s.pi = null;
      LinkedList<Node> Q = new LinkedList<Node>();  //8 create Q
      Q.add(s);                                     //9 ENQUEUE(Q.s)
      while(Q.peek() != null){                      //10 while Q not empty
         Node u = Q.poll();                         //11 u = DEQUEUE(Q)
         for(Node v: u.adj){                        //12 for each v in G.Adj[u]
            if(v.color == WHITE){                   //13 if v.color == WHITE
                   v.color = GRAY;                  //14 v.color = GRAY
                   v.d = u.d + 1;                   //15 v.d = u.d + 1
                   v.pi = u;                        //16 v.pi = u
                   Q.add(v);                        //17 ENQUEUE(Q.v)
            }}
         u.color = BLACK;                           //18 u.color = BLACK
      }
   } 

   public void printBFSTree(Graph G) {
      for (Node n: G.nodeList) { 
         if (G.nodeList.indexOf(n) != 0) { 
            System.out.println("Node:"+G.nodeList.indexOf(n)+", parent="+G.nodeList.indexOf(n.pi)+", depth="+n.d);
         }
      }
   } 

    // used in DFS 
   int time; 

   public void DFS(Graph G) {
      for(Node u: G.nodeList){              //1 for each vertex u in G.V
         u.color = WHITE;                   //2 u.color = WHITE
         u.pi = null;                       //3 u.pi = NIL
      }
      time = 0;                             //4 time = 0
      for(int i = 1; i <= G.numNodes; i++){ //5 for each vertex u in G.V
      Node u = G.nodeList.get(i);
         if(u.color == WHITE){              //6 if u.color == WHITE
            DFS_VISIT(G, u);                //7 DFS-VISIT(G,u)
         }}
   }

   public void DFS_VISIT(Graph G, Node u) { 
      time = time + 1;                      //1 time = time + 1 (time++)
      u.d = time;                           //2 u.d = time
      u.color = GRAY;                       //3 u.color = GRAY
      for(Node v: u.adj){                   //4 for each v in F.Adj[u]
         if(v.color == WHITE){              //5 if v.color == WHITE
            v.pi = u;                       //6 v.pi = u
            DFS_VISIT(G, v);                //7 DFS-VISIT(G,u)
         }}
      u.color = BLACK;                      //8 u.color = BLACK
      time = time + 1;                      //9 time = time + 1 (time++)
      u.f = time;                           //10 u.f = time
   } 

   public void printDFSForest(Graph G) {
      for (Node n: G.nodeList) { 
         if (G.nodeList.indexOf(n) != 0) { 
            System.out.println("Node:"+G.nodeList.indexOf(n)+", parent="+G.nodeList.indexOf(n.pi)+", d=="+n.d+", f="+n.f);
         }
      }
   } 

   public void run() {
   // process input, first line is number of nodes, followed by number of edges, each less than 500
   // then each line has one edge, with tail first, then head
      int numNodes = scanner.nextInt();
      int numEdges = scanner.nextInt();
   //System.out.println("numNodes="+numNodes+" numEdges="+numEdges);
   // create the legit nodes
      for(int j = 1; j <=  numNodes ; j++) { 
       //System.out.println("added node "+j);
         Node n = G.addNode();
      } 
   
   // process the legit edges; 
      for (int j = 1; j <= numEdges; j++) {
         int headNum = scanner.nextInt();
         int tailNum = scanner.nextInt();
         //System.out.println("added edge head="+headNum+" tail="+tailNum);
         Node head = G.nodeList.get(headNum);
         Node tail = G.nodeList.get(tailNum);
         G.addEdge(head,tail); 
      }     
   
   //  print out the graph to verify it is correctly read, using the adj list
      for (Node n: G.nodeList) { 
            // have to handle the null zero node 
         if (G.nodeList.indexOf(n) != 0) {  
            System.out.print("node "+G.nodeList.indexOf(n)+":");
            for (Node v: n.adj) { 
               System.out.print(G.nodeList.indexOf(v)+" ");
            } 
            System.out.println();
         }
      } 
   
   // do a BFS from node 1 
      BFS(G,G.nodeList.get(1)); 
   
   // print the result of the BFS
      printBFSTree(G); 
   
   // do a DFS 
      DFS(G); 
   
   //print the result of the DFS
      printDFSForest(G); 
   }

}