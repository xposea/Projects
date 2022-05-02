import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Advent5 {
    public static int largestx = Integer.MIN_VALUE;
    public static int largesty = Integer.MIN_VALUE;
    public static ArrayList<int[]> create() throws Exception{
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day5.txt");
        Scanner sc = new Scanner(file);
        ArrayList<int[]> order = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = (sc.nextLine().replaceAll("[^\\d]"," "));
            Scanner b = new Scanner(line);
            int[] coords = new int[4];
            for (int i = 0; i < 4; i++) {
                coords[i] = (b.nextInt());
                if(coords[i] > largestx && (i == 0 || i == 2)){
                    largestx = coords[i];
                }
                if(coords[i] > largesty && (i == 1 || i == 3)){
                    largesty = coords[i];
                }
            }
            order.add(coords);
            b.close();
        }
        largesty += 1;
        largestx += 1;
        return order;
    }

    public static int[][] addline(int[][] board, int[] line){
        int small = 0;
        int big = 0;
        if(line[0] == line[2]){
            if(line[1] > line[3]){
                small = line[3];
                big = line[1];
            }
            if(line[1] < line[3]){
                small = line[1];
                big = line[3];
            }
            for(int i = small; i <= big; i++){
                board[i][line[0]] += 1;
            }
        }
        else if(line[1] == line[3]){
            if(line[0] > line[2]){
                small = line[2];
                big = line[0];
            }
            if(line[0] < line[2]){
                small = line[0];
                big = line[2];
            }
            for(int i = small; i <= big; i++){
                board[line[1]][i] += 1;
            }
        }
        else if ((line[1] != line[3]) && (line[0] != line[2])){
            int minx = Math.min(line[0],line[2]);
            int maxx = Math.max(line[0],line[2]);
            int miny = Math.min(line[1],line[3]);
            int maxy = Math.max(line[1],line[3]);
            if(line[0] < line[2] && line[1] < line[3]){
                for(int i = minx; i <= maxx; i++){
                    board[miny][i] += 1;
                    miny++;
                }
            }
            if(line[0] < line[2] && line[1] > line[3]){
                for(int i = minx; i <= maxx; i++){
                    board[maxy][i] += 1;
                    maxy--;
                }
            }
            if(line[0] > line[2] && line[1] < line[3]){
                for(int i = maxx; i >= minx; i--){
                    board[miny][i] += 1;
                    miny++;
                }
            }
            if(line[0] > line[2] && line[1] > line[3]){
                for(int i = maxx; i >= minx; i--){
                    board[maxy][i] += 1;
                    maxy--;
                }
            }
        }
        return board;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<int[]> order = create();
        int[][] board = new int[largesty][largestx];
        for(int y = 0; y < largesty; y++){
            for(int x = 0; x < largestx; x++){
                board[y][x] = 0;
            }
        }
        for(int i = 0; i < order.size(); i++){
            board = addline(board,order.get(i));
        }
        int sum = 0;
        for(int i = 0; i < largesty; i++){
            for(int j = 0; j < largestx; j++){
                System.out.print(board[i][j] + " ");
                if(board[i][j] > 1){
                    sum += 1;
                }
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}
