import java.io.File;
import java.util.Scanner;

public class Advent7 {
    public static int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE, lastsum = 0, min = 0, max = 0;
    public static int[] create() throws Exception {
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day7.txt");
        Scanner sc = new Scanner(file);
        String line = sc.nextLine().replaceAll(",", " ");
        sc.close();
        Scanner b = new Scanner(line);
        while(b.hasNextInt()){
            int cur = b.nextInt();
            if(cur < smallest){
                smallest = cur;
            }
            if(cur > largest){
                largest = cur;
            }
        }
        b.close();
        Scanner c = new Scanner(line);
        min = smallest;
        max = largest;
        int[] location = new int[largest + 1];
        while(c.hasNextInt()){
            int cur = c.nextInt();
            location[cur] += 1;
        }
        c.close();
        return location;
    }

    /*public static int binarysearch(int[] location){
        while(smallest <= largest){
            int mid = smallest + (largest - smallest)/2;
            int cursum = fuel(mid,location);
            if(cursum > lastsum){
                largest = mid - 1;
            }
            else if(cursum < lastsum){
                smallest = mid + 1;
            }
            lastsum = cursum;
        }
        return smallest;
    }*/

    public static long fuel(int center, int[] location){
        long sum = 0;
        for(int i = min; i <= max; i++){
            sum += (recursion(Math.abs(center - i))*location[i]);
        }
        return sum;
    }

    public static long recursion(int i){
        if(i == 0){
            return 0;
        }
        return i + recursion(i-1);
    }

    public static void main(String[] args) throws Exception{
        int[] location = create();
        long[] fuelcost = new long[location.length];
        for(int i = 0; i < location.length; i++){
            fuelcost[i] = fuel(i,location);
            System.out.println(i + " " + fuelcost[i]);
        }
        long optimal = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < fuelcost.length; i++){
            if(fuelcost[i] < optimal){
                optimal = fuelcost[i];
                index = i;
            }
        }
        System.out.println(optimal);
        System.out.println(index);
        /*int mostpop = 0;
        for(int i = 0; i < location.length; i++){
            if(location[i] > mostpop){
                mostpop = i;
            }
        }
        lastsum = fuel(mostpop,location);

        int toploc = binarysearch(location);
        System.out.println(toploc);
        System.out.println(fuel(toploc,location));*/
    }
}
