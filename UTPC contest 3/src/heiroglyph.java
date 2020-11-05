import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;


public class heiroglyph {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(k.nextToken());
        int list[] = new int[n];

        k = new StringTokenizer(f.readLine());

        for( int i=0; i< n; i++){
            list[i] = Integer.parseInt(k.nextToken());
        }
        int xor = list[0]^list[1];
        for(int i=2; i< n ; i++){
            xor = xor ^ list[i];
        }
        if(xor==0){
            System.out.println(0);
        }
        else
            System.out.println(1);

    }
    public static String convertBinary(int num){
        int binary[] = new int[40];
        int index = 0;
        String ans="";
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }
        for(int i = index-1;i >= 0;i--){
            ans+=binary[i];
        }
        return ans;
    }

}
