package AoC;

import java.io.File;
import java.util.Scanner;

public class DayTwoAoC2021 {
    public static int Part1(File input) throws Exception{
        Scanner scanner = new Scanner(input);
        int depth = 0, pos = 0;
        while(scanner.hasNextLine()){
            String[] line = scanner.nextLine().split(" ");
            switch (line[0]) {
                case "forward" -> pos += Integer.parseInt(line[1]);
                case "down" -> depth += Integer.parseInt(line[1]);
                case "up" -> depth -= Integer.parseInt(line[1]);
            }
        }
        scanner.close();
        return depth*pos;
    }

    public static int Part2(File input) throws Exception{
        Scanner scanner = new Scanner(input);
        int depth = 0, pos = 0, aim = 0;
        while(scanner.hasNextLine()){
            String[] line = scanner.nextLine().split(" ");
            switch (line[0]) {
                case "forward" -> {
                    pos += Integer.parseInt(line[1]);
                    depth += Integer.parseInt(line[1]) * aim;
                }
                case "down" -> aim += Integer.parseInt(line[1]);
                case "up" -> aim -= Integer.parseInt(line[1]);
            }
        }
        scanner.close();
        return depth*pos;
    }
    public static void main(String[] args) throws Exception{
        File input = new File("InputFiles/Day2.txt");
        System.out.println(Part1(input));
        System.out.println(Part2(input));
    }
}
