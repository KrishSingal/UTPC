import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;

public class kariomart {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(k.nextToken());
        int m = Integer.parseInt(k.nextToken());
        int total=0;
        int sum=0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                int num = (int) (Math.ceil((double)n/i)*Math.ceil((double)m/j));
                System.out.println( i + " " + j + " " + num);
                total +=num;
                sum += num*(i+j)*2;
            }
        }
        System.out.println(sum + " " + total);
        double ceiling = Math.ceil((double)sum/(double)total) - ((double)sum/(double)total);
        double floor = ((double)sum/(double)total) - Math.floor((double)sum/(double)total);

        //System.out.println("ceiling: " + ceiling);
        //System.out.println("floor: " + floor);

        if(ceiling>floor){
            System.out.println((int)(Math.floor((double)sum/(double)total)));
        }
        else
            System.out.println((int)(Math.ceil((double)sum/(double)total)));
    }
}