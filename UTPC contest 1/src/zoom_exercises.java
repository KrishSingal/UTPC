import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;

public class zoom_exercises {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        Map<Long, Integer> map = new HashMap<Long, Integer>();

        int n = Integer.parseInt(k.nextToken());
        long count=0;

        for(int i=0; i<n; i++){
            k = new StringTokenizer(f.readLine());
            long now = Long.parseLong(k.nextToken());
            if(isPrime(now, map)){
                count+= (now*2);
            }
        }

        System.out.println(count);
    }

    public static boolean isPrime(long check, Map<Long, Integer> map){
        if(map.get(check)!= null){
            if(map.get(check)==0){
                return false;
            }
            else
                return true;
        }

        for(long i =2; i<= Math.sqrt(check); i++){
            if(check%i ==0){
                map.put(check,0);
                return false;
            }
        }
        map.put(check, 1);
        return true;
    }
}


