import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;


public class maze {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(k.nextToken());
        int maze[][] = new int[3][n];

        for(int i=0; i< 3;i++){
            k = new StringTokenizer(f.readLine());
            String line = k.nextToken();
            for(int j=0; j<n; j++){
                maze[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        ArrayList<Integer> ones = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(maze[0][i]==1){
                ones.add(i);
            }
        }
        //System.out.println(ones);

        if(ones.isEmpty()){
            System.out.println("Solvable!");
        }


        else {

            //bfs
            ArrayList<point> q = new ArrayList<>();
            boolean visited[][] = new boolean[3][n];
            boolean flag = false;


            for (int i = 0; i < ones.size(); i++) {
                if (flag)
                    break;

                q.clear();

                q.add(new point(0, ones.get(i)));

                while (!q.isEmpty()) {
                    /*for(point h: q){
                        System.out.println(h);
                    }*/

                    point now = q.remove(0);
                    visited[now.x][now.y] = true;

                    int x = now.x;
                    int y = now.y;

                    if (inRange(x + 1, y, n) && maze[x + 1][y] == 1 && !visited[x + 1][y]) {
                        q.add(new point(x + 1, y));
                        if (x == 1) {
                            //System.out.println(x + " " + y);
                            flag = true;
                            break;
                        }
                    }
                    if (inRange(x + 1, y + 1, n) && maze[x + 1][y + 1] == 1 && !visited[x + 1][y + 1]) {
                        q.add(new point(x + 1, y + 1));
                        if (x == 1) {
                            //System.out.println(x + " " + y);
                            flag = true;
                            break;
                        }
                    }
                    if (inRange(x + 1, y - 1, n) && maze[x + 1][y - 1] == 1 && !visited[x + 1][y - 1]) {
                        q.add(new point(x + 1, y - 1));
                        if (x == 1) {
                            //System.out.println(x + " " + y);
                            flag = true;
                            break;
                        }
                    }

                }
            }

            if (flag) {
                System.out.println("Unsolvable!");
            } else
                System.out.println("Solvable!");

        }

        //bfs

        /*
        ArrayList<point> q = new ArrayList<>();
        boolean visited[][]= new boolean[3][n];
        boolean flag = false;


        for(int i=0; i<3; i++) {
            if(flag)
                break;

            q.clear();

            if(maze[i][0]==0) {
                q.add(new point(i, 0));
            }
            else
                continue;

            while (!q.isEmpty()) {
                point now = q.remove(0);
                visited[now.x][now.y] = true;

                int x = now.x;
                int y = now.y;

                if (inRange(x + 1, y, n) && maze[x + 1][y] != 1 && !visited[x + 1][y]) {
                    q.add(new point(x + 1, y));
                    if (y == n - 1) {
                        //System.out.println(x + " " + y);
                        flag = true;
                        break;
                    }
                }
                if (inRange(x, y + 1, n) && maze[x][y + 1] != 1 && !visited[x][y + 1]) {
                    q.add(new point(x, y + 1));
                    if (y + 1 == n - 1) {
                        //System.out.println(x + " " + y);
                        flag = true;
                        break;
                    }
                }
                if (inRange(x - 1, y, n) && maze[x - 1][y] != 1 && !visited[x - 1][y]) {
                    q.add(new point(x - 1, y));
                    if (y == n - 1) {
                        //System.out.println(x + " " + y);
                        flag = true;
                        break;
                    }
                }
                if (inRange(x, y - 1, n) && maze[x][y - 1] != 1 && !visited[x][y - 1]) {
                    q.add(new point(x, y - 1));
                    if (y - 1 == n - 1) {
                        //System.out.println(x + " " + y);
                        flag = true;
                        break;
                    }
                }

            }
        }

        if(flag){
            System.out.println("Solvable!");
        }
        else
            System.out.println("Unsolvable!");*/



    }
    public static boolean inRange(int x, int y, int n){
        return x>=0 && x< 3 && y>=0 & y<n;
    }
}
class point{
    int x;
    int y;

    public point(int x, int y){
        this.x=x;
        this.y =y;
    }

    public String toString(){
        return x+ " " + y;
    }
}