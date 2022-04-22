package AoC;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOneAoC2021 {

    public static int Part1(File input) throws Exception{
        Scanner scanner = new Scanner(input);
        int part1 = 0;
        int last = scanner.nextInt();
        while (scanner.hasNextInt()){
            int current = scanner.nextInt();
            if(current > last) part1++;
            last = current;
        }
        scanner.close();
        return part1;
    }

    public static int Part2(File input) throws Exception{
        Scanner scanner = new Scanner(input);
        ArrayList<Integer> inputArray = new ArrayList<>();
        int part2 = 0;
        while (scanner.hasNextInt()){
            inputArray.add(scanner.nextInt());
        }
        scanner.close();
        for(int i = 0; i < inputArray.size() - 3; i++){
            if(inputArray.get(i + 3) > inputArray.get(i)) part2++;
        }
        return part2;
    }
    public static void main(String[] args) throws Exception {
        File input = new File("InputFiles/Day1.txt");
        System.out.println(Part1(input));
        System.out.println(Part2(input));
    }
}
