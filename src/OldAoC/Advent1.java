import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent1 {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day1.txt");
        Scanner sc = new Scanner(file);
        int temp1 = (Integer.parseInt(sc.nextLine()));
        int temp2 = (Integer.parseInt(sc.nextLine()));
        int temp3 = (Integer.parseInt(sc.nextLine()));
        int count = 0;
        while(sc.hasNextLine()){
            int sum1 = temp1 + temp2 + temp3;
            temp1 = temp2;
            temp2 = temp3;
            temp3 = (Integer.parseInt(sc.nextLine()));
            int sum2 = temp1 + temp2 + temp3;
            if(sum2 > sum1) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}

