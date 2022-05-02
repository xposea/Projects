import java.io.File;
import java.util.Scanner;

public class Advent3 {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day3.txt");
        Scanner sc = new Scanner(file);
        long[] sums = new long[12];
        long[] sums2 = new long[12];
        String[] input = new String[1000];
        String[] input2 = new String[1000];
        boolean one = false;
        boolean one2 = false;
        int count = 1000;
        int count2 = 1000;
        long o = 0;
        long co = 0;
        for(int i = 0; i < 1000; i++){
            input[i] = (sc.nextLine());
            input2[i] = input[i];
        }
        for(int i = 0; i < 12; i++){
            one = false;
            one2 = false;
            for(int j = 0; j < 1000; j++){
                if(input[j] != null && input[j].charAt(i) == '1') {
                    sums[i] += 1;
                }
                if(input2[j] != null && input2[j].charAt(i) == '1') {
                    sums2[i] += 1;
                }
            }
            if(sums[i] >= count/2){
                one = true;
            }
            if(sums2[i] >= count2/2){
                one2 = true;
            }
            if(one == true){
                for (int j = 0; j < 1000; j++) {
                    if (input[j] != null && input[j].charAt(i) == '0' && count > 1) {
                        input[j] = null;
                        count -=1;
                    }
                }
            }
            else if(one == false){
                for(int j = 0; j < 1000; j++) {
                    if(input[j] != null && input[j].charAt(i) == '1' && count > 1) {
                        input[j] = null;
                        count -=1;
                    }
                }
            }
            if(one2 == true) {
                for(int j = 0; j < 1000; j++) {
                    if (input2[j] != null && input2[j].charAt(i) == '1' && count2 > 1) {
                        input2[j] = null;
                        count2 -=1;
                    }
                }
            }
            else if (one2 == false) {
                for(int j = 0; j < 1000; j++) {
                    if (input2[j] != null && input2[j].charAt(i) == '0' && count2 > 1) {
                        input2[j] = null;
                        count2 -=1;
                    }
                }
            }
        }
        for(int j = 0; j < 1000; j++) {
            if (input[j] != null) {
                System.out.println("oxygen " + input[j]);
            }
            if (input2[j] != null) {
                System.out.println("CO2 " + input2[j]);
            }
        }
    }
}
/*public class Advent3 {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day3.txt");
        Scanner sc = new Scanner(file);
        long[] sums = new long[12];
        long gamma = 0;
        long epsilon = 0;
        while(sc.hasNextLine()){
            long num = Long.parseLong(sc.nextLine());
            for(int i = 0; i < 12; i++){
                sums[11-i] += num % 10;
                num /= 10;
            }
        }
        for(int i = 0; i < 12; i ++){
            if(sums[i] <= 500){
                epsilon += (Math.pow(10,(11-i)));
            }
            else if(sums[i] > 500){
                gamma += (Math.pow(10,(11-i)));
            }
        }
        System.out.println("gamma = " + gamma);
        System.out.println("epsilon = " + epsilon);
    }
}*/
