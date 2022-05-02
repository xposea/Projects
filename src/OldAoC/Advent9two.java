import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Advent9two {
    public static ArrayList<ArrayList<Integer>> create() throws Exception {
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day9.txt");
        Scanner sc = new Scanner(file);
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            char[] inputs = line.toCharArray();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < inputs.length; i++){
                temp.add(Character.getNumericValue(inputs[i]) == 9 ? 1 : 0);
            }
            grid.add(temp);
        }
        return grid;
    }

    public static int dfs(ArrayList<ArrayList<Integer>> grid, int y, int x, int size){
        if(x == 0 || y == 0 || x == grid.get(0).size() - 1 || y == grid.size() - 1 || grid.get(y).get(x) == 1){
            return 0;
        }
        grid.get(y).set(x,1);
        return size + dfs(grid, y, x + 1, size) + dfs(grid, y + 1, x, size) + dfs(grid, y - 1, x, size) + dfs(grid, y, x - 1, size);
    }

    public static void main(String[] args) throws Exception{
        ArrayList<ArrayList<Integer>> grid = create();
        ArrayList<Integer> sizes = new ArrayList<>();
        for(int i = 0; i < grid.size(); i++) {
            for(int j = 0; j < grid.get(0).size(); j++){
                if(grid.get(i).get(j) == 0){
                    sizes.add(dfs(grid, i, j, 1));
                }
            }
        }
        Collections.sort(sizes);
        int ans = sizes.get(sizes.size() - 1) * sizes.get(sizes.size() - 2) * sizes.get(sizes.size() - 3);
        System.out.println(ans);
    }
}
