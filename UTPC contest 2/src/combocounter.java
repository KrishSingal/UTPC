import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;

public class combocounter {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(k.nextToken());
        int p = Integer.parseInt(k.nextToken());
        int m = Integer.parseInt(k.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<Integer>());
        }

        int separation = p;

        for (int j =0; j< n-p +1; j++){
            int i= j;
            while(separation>1){
                adj.get(i).add(i+separation-1);
                adj.get(i + separation -1).add(i);
                separation -=2;
                i++;
            }
            separation =p;
        }

        //traverse bfs
        //System.out.println(adj);

        ArrayList<Integer> q = new ArrayList<Integer>();
        boolean visited[] = new boolean[n];
        Arrays.fill(visited, false);
        int count =1;
        int ret = 0;
        boolean added = false;

        for(int h=0; h<n; h++){
            if(visited[h]==false){
                q.add(h);
                added = true;
            }
            while (!q.isEmpty()) {
                int now = q.remove(0);
                //System.out.println(now);
                visited[now] = true;

                for (int i = 0; i < adj.get(now).size(); i++) {
                    if (visited[adj.get(now).get(i)] == false) {
                        q.add(adj.get(now).get(i));
                    }
                }
            }
            if(added)
                ret++;
            added = false;
        }

        System.out.println(((long)Math.pow(m,ret))%1000000007);

    }
    public static boolean isFull(boolean visited[]){
        for(int i=0; i<visited.length; i++){
            if(visited[i]==false)
            {
                return false;
            }
        }
        return true;
    }
}
