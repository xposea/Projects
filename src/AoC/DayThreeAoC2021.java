package AoC;

import java.io.File;
import java.util.*;

public class DayThreeAoC2021 {
    public static Long Part1(File input) throws Exception{
        Scanner scanner = new Scanner(input);
        ArrayList<String> diagnosticReport = new ArrayList<>();
        while (scanner.hasNext()){
            diagnosticReport.add(scanner.next());
        }
        scanner.close();
        int[] gamma = new int[diagnosticReport.get(0).length()];
        for(int i = 0, j = gamma.length; i < j; i++){
            gamma[i] = 0;
            for(int k = 0,l = diagnosticReport.size(), m = 0;k < l; k++){
                if(diagnosticReport.get(k).charAt(i) == '1') m++;
                if(m > l/2){
                    gamma[i] = 1;
                    break;
                }
            }
        }
        int[] epsilon = new int[gamma.length];
        for(int i = 0, j = gamma.length; i < j; i++){
            if(gamma[i] == 0) epsilon[i] = 1;
        }
        return Long.parseLong(Arrays.toString(gamma).replaceAll("[^\\d]",""),2) * Long.parseLong(Arrays.toString(epsilon).replaceAll("[^\\d]",""),2);
    }

    public static Long Part2(File input) throws Exception{
        Scanner scanner = new Scanner(input);
        int row = 0;
        String line;
        String oxy = "", CO2 = "";
        HashMap<Integer, ArrayList<Character>> grid = new HashMap<>();
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            for(int i = 0, n = line.length(); i < n; i++){
                if(!grid.containsKey(row)) grid.put(row, new ArrayList<>());
                grid.get(row).add(line.charAt(i));
            }
            row++;
        }
        for(int x = 0, y = grid.get(0).size(); x < y; x++) {
            int countOXY = 0, countCO2 = 0, oxyGridSize = 0, co2GridSize = 0;
            for (int i = 0, j = grid.size(); i < j; i++) {
                String binary = grid.get(i).toString().replaceAll("[^\\d]", "");
                if (binary.startsWith(oxy)){
                    oxyGridSize++;
                    if(binary.replaceFirst(oxy, "").startsWith("1")) countOXY++;
                }
                if (binary.startsWith(CO2)){
                    co2GridSize++;
                    if(binary.replaceFirst(CO2, "").startsWith("1")) countCO2++;
                }
            }
            if(oxyGridSize == 1){
                for(int i = 0,j = grid.size(); i < j; i++){
                    if(grid.get(i).toString().replaceAll("[^\\d]", "").startsWith(oxy)) oxy = grid.get(i).toString().replaceAll("[^\\d]", "");
                }
            }
            else if (countOXY >= oxyGridSize / 2.0) {
                oxy = oxy.concat("1");
            }
            else oxy = oxy.concat("0");

            if(co2GridSize == 1){
                for(int i = 0,j = grid.size(); i < j; i++){
                    if(grid.get(i).toString().replaceAll("[^\\d]", "").startsWith(CO2)) CO2 = grid.get(i).toString().replaceAll("[^\\d]", "");
                }
            }
            else if (countCO2 >= co2GridSize / 2.0) {
                CO2 = CO2.concat("0");
            }
            else CO2 = CO2.concat("1");
        }
        return Long.parseLong(oxy.replaceAll("[^\\d]",""),2) * Long.parseLong(CO2.replaceAll("[^\\d]",""),2);
    }

    public static void main(String[] args) throws Exception{
        File input = new File("InputFiles/Day3.txt");
        System.out.println(Part1(input));
        System.out.println(Part2(input));
    }
}
