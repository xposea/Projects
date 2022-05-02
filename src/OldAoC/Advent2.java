import java.io.File;
import java.util.Scanner;

public class Advent2 {
    public static void main(String[] args) throws Exception{
        int vertical = 0;
        int horizontal = 0;
        int aim = 0;
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day2.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNextLine()){
            String line = new String(sc.nextLine());
            String word = line.replaceAll("[^a-z]","");
            int num = Integer.parseInt(line.replaceAll("[^\\d.-]",""));
            if(word.equals("forward")){
                horizontal += num;
                vertical += num * aim;
            }
            else if(word.equals("up")){
                aim -= num;
            }
            else if(word.equals("down")){
                aim += num;
            }
        }
        System.out.println(vertical*horizontal);
    }
}
