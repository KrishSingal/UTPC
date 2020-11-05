import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;

public class zoom_clumps {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(k.nextToken());
        String arr[] = new String[n];
        String curr = "";
        String last ="";
        int count=0;

        for(int i=0; i<n; i++){
            k = new StringTokenizer(f.readLine());
            curr = k.nextToken();
            if(i!=0 && !curr.equals(last)){
                count++;
            }
            last = curr;
        }

        System.out.println(count+1);
    }
}

