import java.io.File;
import java.util.*;

public class Advent11 {
    public static ArrayList<ArrayList<Integer>> create() throws Exception {
            File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day11.txt");
            Scanner sc = new Scanner(file);
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            char[] inputs = line.toCharArray();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < inputs.length; i++) {
                temp.add(Character.getNumericValue(inputs[i]));
            }
            grid.add(temp);
        }
        return grid;
    }

    public static boolean[][] bfs(ArrayList<ArrayList<Integer>> grid, boolean[][] flashed, int y, int x) {
        int up = y + 1, down = y - 1, right = x + 1, left = x - 1;
        if(grid.get(y).get(x) > 9 && !flashed[y][x]){
            flashed[y][x] = true;
            if(x == 0 && y == 0){ //bottom left corner
                grid.get(up).set(right,grid.get(up).get(right) + 1); // up right
                bfs(grid, flashed, up, right);
                grid.get(up).set(x,grid.get(up).get(x) + 1); // up
                bfs(grid, flashed, up, x);
                grid.get(y).set(right,grid.get(y).get(right) + 1); // right
                bfs(grid, flashed, y, right);
            }
            else if (x == grid.get(0).size() - 1 && y == 0){ //bottom right corner
                grid.get(up).set(left,grid.get(up).get(left) + 1); // up left
                bfs(grid, flashed, up, left);
                grid.get(y).set(left,grid.get(y).get(left) + 1); // left
                bfs(grid, flashed, y, left);
                grid.get(up).set(x,grid.get(up).get(x) + 1); // up
                bfs(grid, flashed, up, x);
            }
            else if (y == grid.size() - 1 && x == 0){ //top left corner
                grid.get(down).set(right,grid.get(down).get(right) + 1);// down right
                bfs(grid, flashed, down, right);
                grid.get(down).set(x,grid.get(down).get(x) + 1); // down
                bfs(grid, flashed, down, x);
                grid.get(y).set(right,grid.get(y).get(right) + 1);// right
                bfs(grid, flashed, y, right);
            }
            else if (y == grid.size() - 1 && x == grid.get(0).size() - 1){ // top right corner
                grid.get(down).set(left,grid.get(down).get(left) + 1); // down left
                bfs(grid, flashed, down, left);
                grid.get(down).set(x,grid.get(down).get(x) + 1); // down
                bfs(grid, flashed, down, x);
                grid.get(y).set(left,grid.get(y).get(left) + 1); // left
                bfs(grid, flashed, y, left);
            }
            else if(x == 0){ // left edge
                grid.get(up).set(x,grid.get(up).get(x) + 1); // up
                bfs(grid, flashed, up, x);
                grid.get(y).set(right,grid.get(y).get(right) + 1); // right
                bfs(grid, flashed, y, right);
                grid.get(down).set(right,grid.get(down).get(right) + 1); // down right
                bfs(grid, flashed, down, right);
                grid.get(down).set(x,grid.get(down).get(x) + 1); // down
                bfs(grid, flashed, down, x);
                grid.get(up).set(right,grid.get(up).get(right) + 1); //up right
                bfs(grid, flashed, up, right);
            }
            else if(x == grid.get(0).size() - 1){ // right corner
                grid.get(up).set(x,grid.get(up).get(x) + 1); //up
                bfs(grid, flashed, up, x);
                grid.get(y).set(left,grid.get(y).get(left) + 1); //left
                bfs(grid, flashed, y, left);
                grid.get(down).set(left,grid.get(down).get(left) + 1);//down left
                bfs(grid, flashed, down, left);
                grid.get(down).set(x,grid.get(down).get(x) + 1);//down
                bfs(grid, flashed, down, x);
                grid.get(up).set(left,grid.get(up).get(left) + 1);//up left
                bfs(grid, flashed, up, left);
            }
            else if(y == 0){ //bottom edge
                grid.get(y).set(left,grid.get(y).get(left) + 1); //left
                bfs(grid, flashed, y, left);
                grid.get(y).set(right,grid.get(y).get(right) + 1);//right
                bfs(grid, flashed, y, right);
                grid.get(up).set(x,grid.get(up).get(x) + 1);//up
                bfs(grid, flashed, up, x);
                grid.get(up).set(left,grid.get(up).get(left) + 1);//up left
                bfs(grid, flashed, up, left);
                grid.get(up).set(right,grid.get(up).get(right) + 1);//up right
                bfs(grid, flashed, up, right);
            }
            else if(y == grid.size() - 1){ // top edge
                bfs(grid, flashed, down, left);
                grid.get(down).set(x,grid.get(down).get(x) + 1);//down
                bfs(grid, flashed, down, x);
                grid.get(y).set(right,grid.get(y).get(right) + 1);//right
                bfs(grid, flashed, y, right);
                grid.get(down).set(right,grid.get(down).get(right) + 1);//down right
                bfs(grid, flashed, down, right);
                grid.get(y).set(left,grid.get(y).get(left) + 1); // left
                bfs(grid, flashed, y, left);
                grid.get(down).set(left,grid.get(down).get(left) + 1);// down left
                bfs(grid, flashed, down, left);
            }
            else{
                grid.get(down).set(left,grid.get(down).get(left) + 1);// down left
                bfs(grid, flashed, down, left);
                grid.get(down).set(right,grid.get(down).get(right) + 1);//down right
                bfs(grid, flashed, down, right);
                grid.get(up).set(left,grid.get(up).get(left) + 1);//up left
                bfs(grid, flashed, up, left);
                grid.get(up).set(right,grid.get(up).get(right) + 1);// up right
                bfs(grid, flashed, up, right);
                grid.get(down).set(x,grid.get(down).get(x) + 1);//down
                bfs(grid, flashed, down, x);
                grid.get(y).set(left,grid.get(y).get(left) + 1);//left
                bfs(grid, flashed, y, left);
                grid.get(up).set(x,grid.get(up).get(x) + 1);//up
                bfs(grid, flashed, up, x);
                grid.get(y).set(right,grid.get(y).get(right) + 1);//right
                bfs(grid, flashed, y, right);
            }
        }
        return flashed;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<ArrayList<Integer>> grid = create();
        int sum = 0;
        boolean stop = false;
        for (int i = 0; !stop ; i++) { //testing 1 instead of 100
            Queue<int[]> coord = new ArrayDeque<>();
            boolean[][] flashed = new boolean[grid.size()][grid.get(0).size()];
            for (int j = 0; j < grid.size(); j++) {
                for (int k = 0; k < grid.get(0).size(); k++) {
                    grid.get(j).set(k, grid.get(j).get(k) + 1);
                    if(grid.get(j).get(k) > 9){
                        int[] coords = {j,k};
                        coord.add(coords);
                    }
                }
            }
            while(!coord.isEmpty()) {
                int[] temp= coord.poll();
                flashed = bfs(grid, flashed, (temp[0]), temp[1]);
            }
            int smallsum = 0;
            for(int k = 0; k < grid.size(); k++){
                for(int j = 0; j < grid.get(0).size(); j++){
                    if(flashed[k][j]){
                        grid.get(k).set(j, 0);
                        smallsum += 1;
                    }
                }
            }
            if(smallsum == ((grid.size()) * (grid.get(0).size()))){
                System.out.println(i + 1);
                stop = true;
                System.out.println(smallsum);

            }
            sum += smallsum;
        }
        System.out.println(sum);
    }
}
