import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Advent4 {
    public static boolean winner(int[][] board){ //Check if board has won
        boolean win = false;
        int sumrow, sumcol;
        for(int i = 0; i < 5; i++){
            sumrow = 0;
            sumcol = 0;
            for(int j = 0; j < 5; j++){
                if(board[i][j] == -100){
                    sumrow += -100;
                }
                if(board[j][i] == -100){
                    sumcol += -100;
                }
            }
            if(sumrow == -500 || sumcol == -500){
                win = true;
            }
        }
        return win;
    }
    public static int[][] nuke(int[][] board){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                board[i][j] = -200;
            }
        }
        return board;
    }
    public static void print(int[][] board){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int sum(int[][] board){
        int sum = 0;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(board[i][j] != -100){
                    sum += board[i][j];
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Dylan\\IdeaProjects\\NOINT\\src\\day4.txt");
        Scanner sc = new Scanner(file);
        String balls = (sc.nextLine());
        ArrayList<Integer> order = new ArrayList<>();
        balls = balls.replaceAll(",", " ");
        Scanner b = new Scanner(balls);
        ArrayList<Integer> boards = new ArrayList<>();
        while (b.hasNext()) {
            order.add(Integer.parseInt(b.next()));
        }
        b.close();
        sc.nextLine();
        int[][][] board = new int[100][5][5]; //Creates 3D array from inputs file
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[i][j][k] = sc.nextInt();
                }
            }
        }
        for(int i = 0; i < order.size(); i++){
            for(int j = 0; j < 100; j++){
                for(int k = 0; k < 5; k++){
                    for(int l = 0; l < 5; l++){
                        if(board[j][k][l] == order.get(i)){
                            board[j][k][l] = -100;
                            if(winner(board[j])){
                                boards.add(j);
                                if(boards.size() != 100){
                                    board[j] = nuke(board[j]);
                                }
                                if(boards.size() == 100){
                                    print(board[j]);
                                    System.out.println(order.get(i) * sum(board[j]));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}