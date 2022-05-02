package AoC;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class DayFourAoc2021 {

    public static int Part1(ArrayList<Integer> bingoBalls, HashMap<Integer,Integer[][]> bingoBoards) throws Exception{

        return 1;
    }

    public static int Part2(ArrayList<Integer> bingoBalls, HashMap<Integer,Integer[][]> bingoBoards) throws Exception{
        return 1;
    }

    public static void main(String[] args) throws Exception{
        File input = new File("InputFiles/Day4.txt");
        Scanner scanner = new Scanner(input);
        List<Integer> bingoBalls = Arrays.stream(scanner.nextLine().split(","))
                .map(Integer::parseInt).collect(Collectors.toList());

    }
}
