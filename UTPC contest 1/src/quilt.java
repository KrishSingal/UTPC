import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;

public class quilt {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(k.nextToken());
        int s = Integer.parseInt(k.nextToken());

        String all_tiles[][][] = new String[n][s][s];

        for( int i=0; i<n ; i++){
            for(int j=0; j<s; j++){
                k = new StringTokenizer(f.readLine());
                for(int m=0; m<s; m++){
                    all_tiles[i][j][m] = k.nextToken();
                }
            }
        }

        k = new StringTokenizer(f.readLine());
        int quilt_w = Integer.parseInt(k.nextToken());
        int quilt_h = Integer.parseInt(k.nextToken());

        for(int i= 0; i<quilt_h; i++){
            for(int j=0; j<quilt_h; j++){
                String now = k.nextToken();
                int sheet = Integer.parseInt(now.substring(0,1));
                int transformation = Integer.parseInt(now.substring(2,3));
                if(transformation <=3){
                    String do_it [][]= all_tiles[sheet];
                    for(int h=0; h<transformation; h++){
                        do_it = ninety(do_it);
                    }
                }
            }
        }



    }

    public static String[][] ninety(String[][] arr){

    }
}



