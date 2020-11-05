import java.io.*;
import java.util.StringTokenizer;
import java.util.*;
import java.lang.*;

public class Spooky {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("feast.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
        //PrintWriter out = new PrintWriter(System.out, true);
        StringTokenizer k = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(k.nextToken());

        k = new StringTokenizer(f.readLine());

        //int nums[] = new int[n];
        ArrayList<Integer> nums = new ArrayList<Integer> ();
        int sum = 0;
        boolean all0= true;

        for(int i=0; i<n; i++){
            nums.add(Integer.parseInt(k.nextToken()));
            sum += nums.get(i);
            sum = sum %3;
            if(nums.get(i)!=0){
                all0=false;
            }
        }
        sum= sum%3;

        Collections.sort(nums, Collections.reverseOrder());

        /*for(int i: nums){
            System.out.print(i);
        }
        System.out.println(sum);*/

        int index1tr =-1;
        int index2tr=-1;
        String ret ="";

        if(all0){
            System.out.println(0);
            System.exit(0);
        }

        if(nums.get(nums.size()-1) != 0) {
            System.out.println(-1);
            System.exit(0);
        }
        if(sum==0){
            for(int i=0; i< nums.size(); i++){
                ret += "" + nums.get(i);
            }
            System.out.println(ret);
            System.exit(0);
        }

        /////
        for(int i=nums.size()-1; i>=0; i--){
            if(nums.get(i)%3 ==sum){
                index1tr = i;
                break;
            }
        }
        if(index1tr!=-1) {

            for(int j=0; j< nums.size(); j++){
                if(j!=index1tr){
                    ret += nums.get(j) ;
                }
            }

            System.out.println(ret);
            System.exit(0);
        }
        //////


        ret= "";

        int best1=-1;
        int best2=-1;

        /*
        for(int i=index; i>=0; i-- ){
            for(int j=i-1; j>=0; j--){
                if((nums[i]+nums[j]) %3 == sum && j>best2){
                        best2=j;
                        best1=i;
                }
            }
        }*/

        int looking = 3 - sum;
        int count=0;

        for(int i =nums.size()-1; i>=0; i--){
            if(nums.get(i)%3 == looking && count==0){
                best1= i;
                count++;
            }
            else if(nums.get(i)%3 == looking && count==1){
                best2 =i;
                break;
            }
        }

        for(int j=0; j< nums.size(); j++){
            if(j!=best1 && j!= best2){
                ret += nums.get(j);
            }
        }

        System.out.println(ret);
        System.exit(0);

    }
}
