import java.util.ArrayList;


public class Node {


    ArrayList<Node>  adj;  // linked list of pointers to adjacent nodes 
    int  color; // node color in DFS, BFS
    // 1 = WHITE, 2 = GRAY, 3 = BLACK 
    int d;  // distance from root in BFS, discovery time in DFS
    int f;  // finish time in DFS
    Node pi; // parent in DFS or BFS tree
} 