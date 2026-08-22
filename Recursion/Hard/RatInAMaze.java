import java.util.*;
class RatInAMaze
{
    static ArrayList < String > findPaths(int[][] maze)
    {
        ArrayList < String > ans = new ArrayList<>();
        int N = maze.length;
        int[][] visited = new int[N][N];
        if(maze[0][0] == 1)
        {
            generate(0 , 0 , N ,  maze , visited , "" , ans);
        }
        return ans;
    }

    static void generate(int x , int y , int N , int[][] maze , int[][] visited , String current , ArrayList < String > ans)
    {
        if(x == N - 1 && y == N - 1)
        {
            ans.add(current);
            return;
        }
        
        visited[x][y] = 1;

        //move down
        if(isSafe(x + 1 , y , N , maze , visited))
        {
            generate(x + 1 , y , N , maze , visited , current + 'D' , ans);
        }

        //move left
        if(isSafe(x , y - 1 , N , maze , visited))
        {
            generate(x , y - 1 , N , maze , visited , current + 'L' , ans);
        }   

        //move right
        if(isSafe(x , y + 1 , N , maze , visited))
        {
            generate(x , y + 1 , N , maze , visited , current + 'R' , ans);
        }

        //move up
        if(isSafe(x - 1 , y , N , maze , visited))
        {
            generate(x - 1 , y , N , maze , visited , current + 'U' , ans);
        }

        //backtrack
        visited[x][y] = 0;
    }

    static boolean isSafe(int x , int y , int N , int[][] maze , int[][] visited)
    {
        return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1 && visited[x][y] == 0);
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n : ");
        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        System.out.println("Enter " + n*n + " array elements");
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                maze[i][j] = sc.nextInt();
            }
        }
        ArrayList < String > ans = findPaths(maze);
        for(String X : ans)
        {
            System.out.println(X + " ");
        }
    }
}