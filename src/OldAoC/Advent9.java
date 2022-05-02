import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent9 {
    public static int sum = 0;
    public static ArrayList<ArrayList<Integer>> create() throws Exception {
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day9.txt");
        Scanner sc = new Scanner(file);
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            char[] inputs = line.toCharArray();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < inputs.length; i++){
                temp.add(Character.getNumericValue(inputs[i]));
            }
            grid.add(temp);
        }
        return grid;
    }

    public static ArrayList<Integer> compareHorizontal(ArrayList<ArrayList<Integer>> grid, int row){
        ArrayList<Integer> horiz = new ArrayList<>();
        for(int j = 0; j < grid.get(0).size(); j++){
            if(j == 0) {
                if (grid.get(row).get(j) < grid.get(row).get(1)) {
                    horiz.add(j);
                }
            }
            else if(j == grid.get(row).size() - 1){
                if(grid.get(row).get(j) < grid.get(row).get(j - 1)) {
                    horiz.add(j);
                }
            }
            else if((grid.get(row).get(j) < (grid.get(row).get(j - 1)))&& (grid.get(row).get(j) < (grid.get(row).get(j + 1)))){
                horiz.add(j);
            }
        }
        return horiz;
    }

    public static void compareVertical(ArrayList<ArrayList<Integer>> grid, int row, ArrayList<Integer> horiz){
        ArrayList<Integer> total = new ArrayList<>();
        for(int i = 0; i < horiz.size(); i++){
            if(row == 0) {
                if (grid.get(row).get(horiz.get(i)) < grid.get(row + 1).get(horiz.get(i))) {
                    sum += 1 + grid.get(row).get(horiz.get(i));
                }
            }
            else if(row == grid.size() - 1) {
                if (grid.get(row).get(horiz.get(i)) < grid.get(row - 1).get(horiz.get(i))) {
                    sum += 1 + grid.get(row).get(horiz.get(i));
                }
            }
            else if(grid.get(row).get(horiz.get(i)) < grid.get(row - 1).get(horiz.get(i)) &&  grid.get(row).get(horiz.get(i)) < grid.get(row + 1).get(horiz.get(i))){
                sum += 1 + grid.get(row).get(horiz.get(i));
            }
        }
    }

    public static void main(String[] args) throws Exception{
        ArrayList<ArrayList<Integer>> grid = create();
        for(int i = 0; i < grid.size(); i++){
            ArrayList<Integer> horiz = compareHorizontal(grid,i);
            compareVertical(grid, i, horiz);
        }
        System.out.println(sum);
    }
}
