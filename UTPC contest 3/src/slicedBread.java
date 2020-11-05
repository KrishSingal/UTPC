import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;

public class slicedBread{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(k.nextToken());

        Map<String, Integer> months = new HashMap<>();
        months.put("Jan", 1);
        months.put("Feb", 2);
        months.put("Mar", 3);
        months.put("Apr", 4);
        months.put("May", 5);
        months.put("Jun", 6);
        months.put("Jul", 7);
        months.put("Aug", 8);
        months.put("Sep", 9);
        months.put("Oct", 10);
        months.put("Nov", 11);
        months.put("Dec", 12);

        invention inv[] = new invention[n];

        //System.out.println(months);
        for(int i=0; i<n; i++){
                String invention = f.readLine();
                k = new StringTokenizer(f.readLine());
                //System.out.println(k.nextToken());
                int month = months.get(k.nextToken());

                String day = k.nextToken();
                int dayv = Integer.parseInt(day.substring(0, day.length()-1));
                int year = Integer.parseInt(k.nextToken());
                k = new StringTokenizer(f.readLine());
                double score = Double.parseDouble(k.nextToken());
                inv[i] = new invention(invention, month, dayv, year, score);
            //System.out.println("hi");
        }

        Arrays.sort(inv);
        /*for( invention i: inv){
            System.out.println(i);
        }*/

        boolean flag = true;
        int index = n-1;
        while(index >-1 && flag){
            if(after(inv[index])){
                System.out.println(inv[index].name);
                flag=false;
            }
            else
                index--;
        }

    }
    public static boolean after(invention now){
        if(now.year > 1933){
            return true;
        }
        else if(now.year ==1933 && now.month >= 7 && now.day > 7){
            return true;
        }

        return false;
    }
}
class invention implements Comparable<invention>{
    String name;
    int month;
    int  day;
  int year;
    double score;

    public invention(String n, int m, int d, int y, double s){
        name = n;
        month = m;
        day =d;
        year =y;
        score=s;
    }
    public int compareTo(invention other){
        if(this.score> other.score){
            return 1;
        }
        else
            return -1;
    }

    public String toString(){
        return name + " " + month + " " + day + " " + year + " " + score;
    }

}


