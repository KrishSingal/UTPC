import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;

public class headquarters {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(k.nextToken());
        int x_total =0;
        int y_total =0;
        int total_pop=0;

        for(int i=0; i<n; i++){
            k = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(k.nextToken());
            int y = Integer.parseInt(k.nextToken());
            int curr_pop = Integer.parseInt(k.nextToken());
            x_total += (curr_pop*x);
            y_total += (curr_pop*y);
            total_pop += curr_pop;
        }

        double x_coord = ((double)x_total) / ((double)total_pop);
        double y_coord = ((double)y_total) / ((double)total_pop);
        System.out.print(x_coord + " " + y_coord);


    }
}
