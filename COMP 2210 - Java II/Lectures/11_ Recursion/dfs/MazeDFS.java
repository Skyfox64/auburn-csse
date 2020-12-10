/**
 * MazeDFS.java. Explores a maze from different starting points
 * looking for goal positions.
 *
 * @author    Dean Hendrix (dh@auburn.edu)
 * @version   2013-10-16
 *
 */
public class MazeDFS {

   private char[][] maze;         // the maze
   private boolean[][] visited;   // cells visited

/*
 Maze notation:
    '-' : open
    'x' : blocked
    'G' : goal
*/

// example mazes
   public static char[][] DEFAULT_MAZE = 
   {
      {'-','x','x','x','-','-','-'},
      {'-','x','-','x','-','-','-'},
      {'G','x','-','-','-','-','-'},
      {'-','-','G','x','-','G','-'},
      {'-','x','-','x','-','-','-'},
      {'-','G','x','x','-','-','-'},
      {'-','-','G','x','-','-','-'}
      };
      
   public static char[][] MAZE1 = 
   {
      {'-','x','x','x','-','-','-'},
      {'-','x','-','x','-','-','-'},
      {'G','x','-','x','-','-','-'},
      {'-','x','G','x','-','G','-'},
      {'-','x','x','x','-','-','-'},
      {'-','G','x','x','-','-','-'},
      {'-','-','G','x','-','-','-'}
      };
      
      
/**
 * Initialize with a specified maze.
 */      
   public MazeDFS(char[][] m) {
      maze = m;
      visited = new boolean[maze.length][maze.length];
      for (int i = 0; i < visited.length; i++)
         for (int j = 0; j < visited.length; j++)
            visited[i][j] = false;
   }
   
   
/**
 * Initialize with a default maze.
 */
   public MazeDFS() {
      this(DEFAULT_MAZE);
   }


   private static char[] maze1d = {'-', '-', '-', '-', 'G', '-', '-', '-', '-', '-', '-'};
   private static boolean[] visited1d = new boolean[11];

   
/**
 *  Recursive linear search of an array.
 *  Basis for dfs0 below.
 */   
   public static boolean contains(char[] a, int left, int right, char target) {
      if (left > right)
         return false;
      else {
         if (a[left] == target)
            return true;
         else
            return contains(a, left + 1, right, target);
      }
   }
   
////////////////////////////////////////////////////////////////////////////////   
/**
 * Motivation for dfs: 1-dimensional maze.
 * Depending on the starting point of the search
 * and the presence of a G, this can generate either
 * an index out of bounds error or a stack overflow:
 * stack overflow because we're not marking the 
 * positions that we've visited; index out of bounds
 * because x is incremented and decremented without
 * checking against the array bounds.
 */
   public void dfs0_0(int x) {
      if (maze1d[x] == 'G')
         return;
         
      dfs0_0(x + 1);
      dfs0_0(x - 1);
   }

/**
 * At this point, we would need to take into 
 * consideration the problem being solved. For
 * example, find first G, find all G's, etc.
 * Note that the amount of the search space that
 * gets explored depends on the starting position
 * of the search.
 */
   public void dfs0_1(int x) {
      if (!valid(x))
         return;
   
      visited1d[x] = true;
      if (maze1d[x] == 'G')
         return;
         
      dfs0_1(x + 1);
      dfs0_1(x - 1);
   }


////////////////////////////////////////////////////////////////////////////////   
/**
 * Basic dfs starting point. Generates exception since
 * no index validation is done.
 */
   public void dfs1(int x, int y) {
      if (isGoal(x, y)) {
         return;
      }
      dfs1(x - 1, y);      // N
      dfs1(x - 1, y + 1);  // NE
      dfs1(x, y + 1);      // E
      dfs1(x + 1, y + 1);  // SE
      dfs1(x + 1, y);      // S
      dfs1(x + 1, y - 1);  // SW
      dfs1(x, y - 1);      // W
      dfs1(x - 1, y - 1);  // NW
   }
   
/**
 * Step 2 in dfs development. Adds index checking.
 * Generates stack overflow since positions aren't
 * marked as visited.
 */
   public void dfs2(int x, int y) {
      if (!valid(x, y)) {
         return;
      }
   
      if (isGoal(x, y)) {
         return;
      }
      dfs2(x - 1, y);      // N
      dfs2(x - 1, y + 1);  // NE
      dfs2(x, y + 1);      // E
      dfs2(x + 1, y + 1);  // SE
      dfs2(x + 1, y);      // S
      dfs2(x + 1, y - 1);  // SW
      dfs2(x, y - 1);      // W
      dfs2(x - 1, y - 1);  // NW
   }
   
   
/**
 * Step 3 in dfs development. Adds marking positions
 * as visited.
 * Notice how the starting position affects the number
 * of goal states that are found.
 * At this point, the evolution of dfs will be guided
 * by the nature of the problem being solved.
 */
   public void dfs3(int x, int y) {
      if (!valid(x, y)) {
         return;
      }
   
      visited[x][y] = true;
      if (isGoal(x, y)) {
         return;
      }
      dfs3(x - 1, y);      // N
      dfs3(x - 1, y + 1);  // NE
      dfs3(x, y + 1);      // E
      dfs3(x + 1, y + 1);  // SE
      dfs3(x + 1, y);      // S
      dfs3(x + 1, y - 1);  // SW
      dfs3(x, y - 1);      // W
      dfs3(x - 1, y - 1);  // NW
   }
   
   
   private boolean isGoal(int x, int y) {
      return maze[x][y] == 'G';
   }
   
   
/**
 * Displays maze to stdout.
 */   
   public void showMaze() {
      for (int i = 0; i < maze.length; i++) {
         for (int j = 0; j < maze.length; j++) {
            System.out.printf("%3s", maze[i][j]);
         }
         System.out.println();
      }
   }
   
/**
 * Displays maze with visited information to stdout.
 */   
   public void showVisited() {
      for (int i = 0; i < visited.length; i++) {
         for (int j = 0; j < visited.length; j++) {
            if (visited[i][j])
               System.out.printf("%3s", "o");
            else
               System.out.printf("%3s", maze[i][j]);
         }
         System.out.println();
      }
   }
   
/**
 * Is (i, j) a valid position in the maze?
 */
   private boolean valid(int i, int j) {
      return (i >= 0) && (i < maze.length) && 
            (j >= 0) && (j < maze.length) &&
             maze[i][j] != 'x' &&
             !visited[i][j];
   }
   
   
   private boolean valid(int x) {
      return (x >= 0) && (x < maze1d.length) &&
         !visited1d[x];
   }
   
   
/**
 * Mark all maze positions as unvisited.
 */   
   private void markUnvisited() {
      for (int i = 0; i < visited.length; i++)
         for (int j = 0; j < visited.length; j++)
            visited[i][j] = false;
   }
   
   
/**
 * Sample client.
 */
   public static void main(String[] args) {
   
      MazeDFS maze = new MazeDFS();
      maze.showMaze();
      maze.dfs3(0,5);
      System.out.println("\n\n");
      maze.showVisited();
      
   }



}